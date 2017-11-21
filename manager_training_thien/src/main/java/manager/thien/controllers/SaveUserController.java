/**
 * Copyright(C) 2016 Luvina Software Company
 * SaveUserController.java Sep 13, 2016 nguyenducthien
 */
package manager.thien.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import manager.thien.models.Company;
import manager.thien.models.Insurance;
import manager.thien.models.User;
import manager.thien.services.CompanyService;
import manager.thien.services.InsuranceService;
import manager.thien.services.UserService;
import manager.thien.utils.Common;
import manager.thien.utils.Constant;
import manager.thien.validator.UserValidator;
import manager.thien.validator.Validator;


/**
 * Dùng để thêm mới user, cập nhật user
 * @author nguyenducthien
 *
 */
@Controller
public class SaveUserController {
	@Autowired
	UserService userService;
	@Autowired
	CompanyService companyService;
	@Autowired
	InsuranceService insuranceService;
	@Autowired 
	Validator validator;
	/**
	 * Dùng để xử lý khi gọi url:
	 * -Thêm mới một user
	 * -Cập nhật một user
	 * @param id int của user cần cập nhật 
	 * @return Màn hình hiển thị ADM004
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.GET)
	ModelAndView gotoSaveUser(String id, String tabID, String companyId) {
		ModelAndView model = new ModelAndView();
		List<Company> listCompany = companyService.getAllCompany();
		UserValidator userValidator = new UserValidator();
		tabID = (tabID != null) ? tabID : "";
		User user = null;
		//Kiểm tra xem id có tồn tại hay không để biết được là thêm mới hay cập nhật
		if (id != null ) {
			user = userService.getUserById(Integer.parseInt(id));
		} 
		if (user == null) {
			//Khi thêm mới
			//Đặt giá trị mặc định khi thêm mới
			String date = Common.dateInString(new Date());
			userValidator.setId("0");
			userValidator.setInsuranceId("0");
			userValidator.setInsuranceCode("");
			userValidator.setFullName("");
			userValidator.setSex(Constant.MALE);
			userValidator.setBirthday("");
			userValidator.setIsChoseOld((listCompany.size() > 0) ? "true" : "false");
			if (listCompany.size() > 0) {
				userValidator.setIsChoseOld("true");
			} else {
				userValidator.setIsChoseOld("false");
			}
			userValidator.setStartDate(date);
			userValidator.setEndDate(date);
			userValidator.setPlaceRegister("");
		} else {
			//Khi cập nhật
			companyId = user.getCompany().getId() + "";
			userValidator.setId(user.getId() + "");
			userValidator.setInsuranceId(user.getInsurance().getId() + "");
			userValidator.setIsChoseOld("true");
			userValidator.setInsuranceCode(user.getInsurance().getCode());
			userValidator.setFullName(user.getFullName());
			userValidator.setSex(user.getSex() + "");
			if (user.getBirthday() != null) {
				userValidator.setBirthday(Common.dateInString(user.getBirthday()));
			}
			userValidator.setCompanyId(user.getCompany().getId() + "");
			userValidator.setCompanyName(user.getCompany().getName());
			userValidator.setCompanyAddress(user.getCompany().getAddress());
			userValidator.setCompanyEmail(user.getCompany().getEmail());
			userValidator.setCompanyTel(user.getCompany().getTel());
			
			userValidator.setStartDate(Common.dateInString(user.getInsurance().getStartDate()));
			userValidator.setEndDate(Common.dateInString(user.getInsurance().getEndDate()));
			userValidator.setPlaceRegister(user.getInsurance().getPlaceRegister());
		}
		//Khi không lấy được companyId hoặc company với companyId không tồn tại
		if (listCompany.size() > 0) {
			try {
				int intCompanyId = Integer.parseInt(companyId);
				if (companyService.getCompanyById(intCompanyId) == null) {
					throw new Exception();
				}
			} catch (Exception ex) {
				companyId = listCompany.get(0).getId() + "";
			}
		}
		model.addObject("tabID", tabID);
		model.addObject("listCompany", listCompany);
		model.addObject("defaultCompanyId", companyId);
		model.addObject("user", userValidator);
		model.setViewName(Constant.ADM004);
		return model;
	}
	/**
	 * Xử lý khi click vào button submit tại trang ADM004
	 * @param id String id của user 
	 * @param insuranceCode String mã bảo hiểm
	 * @param fullName String họ và tên
	 * @param sex char 1/2 giới tính
	 * @param birthday String birthday
	 * @param isChoseOld String true/false
	 * @param placeRegister String nơi đăng ký bảo hiểm
	 * @param startDate String date
	 * @param endDate String date
	 * @param companyId String id của company của user đó
	 * @param companyName String name của company của user đó
	 * @param companyAddress String address của company của user đó
	 * @param companyEmail String email của company của user đó
	 * @param companyTel String tel của company của user đó
	 * @return Màn hình hiển thị ADM004 nếu có lỗi không thì chuyển màn hình ADM002
	 * @throws Exception 
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	ModelAndView addUser(
			String id,
			String insuranceCode,
			String insuranceId,
			String fullName, 
			String sex, 
			String birthday,
			String isChoseOld,
			String placeRegister, 
			String startDate, 
			String endDate,
			String companyId,
			String companyName,
			String companyAddress,
			String companyEmail,
			String companyTel,
			String tabID) throws Exception {
		ModelAndView model = new ModelAndView();
		//Trim() dữ liệu string
		insuranceCode = insuranceCode.trim();
		fullName = fullName.trim();
		placeRegister = placeRegister.trim();
		companyName = companyName.trim();
		companyAddress = companyAddress.trim();
		companyEmail = companyEmail.trim();
		companyTel = companyTel.trim();
		//Lấy hết dữ liệu để validate
		UserValidator userValidator = new UserValidator(
				id, 
				insuranceCode,
				insuranceId,
				fullName, 
				sex, 
				birthday, 
				isChoseOld, 
				placeRegister, 
				startDate, 
				endDate, 
				companyId, 
				companyName, 
				companyAddress, 
				companyEmail, 
				companyTel);
		//Khi không có công ty nào
		companyId = (companyId != null) ? companyId : "0";
		if (validator.isValidateUser(userValidator)) {
			//Nếu không có lỗi
			//Tạo object company để lưu hoặc thêm mới
			Company company;
			Insurance insurance;
			//Nếu chọn công ty trong list
			if (Boolean.parseBoolean(isChoseOld)) {
				company = companyService.getCompanyById(Integer.parseInt(companyId));
			} else {
				company = new Company();
				company.setName(Common.formattingName(companyName));
				company.setAddress(companyAddress);
				//Khi nhập email
				if (!Common.isEmpty(companyEmail)) {
					company.setEmail(companyEmail);
				}
				//Khi nhập số điện thoại
				if (!Common.isEmpty(companyTel)) {
					company.setTel(companyTel);
				}
			}
			//Lấy insurance nếu là cập nhật
			insurance = insuranceService.getInsuranceById(Integer.parseInt(insuranceId));
			//Thêm mới khi chưa có
			if (insurance == null) {
				insurance = new Insurance();
			} 
			//Đặt giá chị cho insurance từ form
			insurance.setId(Integer.parseInt(insuranceId));
			insurance.setCode(insuranceCode);
			insurance.setEndDate(Common.toDate(endDate));
			insurance.setStartDate(Common.toDate(startDate));
			insurance.setPlaceRegister(placeRegister);
			//Tạo mới user để thêm mới hoặc cập nhật
			User user = new User();
			user.setId(Integer.parseInt(id));
			user.setFullName(Common.formattingName(fullName));
			//Khi nhập ngày sinh
			if (!Common.isEmpty(birthday)) {
				user.setBirthday(Common.toDate(birthday));
			}
			user.setSex(("2".equals(sex) ? '2' : '1'));
			user.setUserName(Common.getLoginName(fullName));
			user.setPassword(Common.getMD5Password(fullName));
			user.setCompany(company);
			user.setInsurance(insurance);
			if (userService.saveUser(user)) {
				//Khi lưu thành công thì trở về trang ADM002 với company đã chọn
				model.setViewName("redirect:listUsers?companyId=" + user.getCompany().getId());
			} else {
				//Sẽ bắn ra exception để cho ExceptionHandling xử lý
				throw new Exception();
			}
		} else {
			//Khi có lỗi
			List<Company> listCompany = companyService.getAllCompany();
			model.addObject("listCompany", listCompany);
			List<String> errors = validator.getErrors();
			model.addObject("errors", errors);
			model.addObject("user", userValidator);
			model.addObject("defaultCompanyId", companyId);
			model.addObject("tabID", tabID);
			model.setViewName(Constant.ADM004);
		}
		return model;
	}
}
