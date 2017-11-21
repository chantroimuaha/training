/**
 * Copyright(C) 2016 Luvina Software Company
 * Validator.java Sep 19, 2016 nguyenducthien
 */
package manager.thien.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import manager.thien.services.CompanyService;
import manager.thien.services.InsuranceService;
import manager.thien.utils.Common;
import manager.thien.utils.MessageErrorProperties;

/**
 * Lớp Validator dùng để validate
 * @author nguyenducthien
 *
 */
@Component
public class Validator {

	private List<String> errors;
	
	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	/**
	 * Dùng để kiểm tra xem có validate không
	 * @param userValidator
	 * @return true nếu không có lỗi
	 */
	public boolean isValidateUser(UserValidator userValidator) {
		int insuranceId = Integer.parseInt(userValidator.getInsuranceId());
		String insuranceCode = userValidator.getInsuranceCode();
		String fullName = userValidator.getFullName();
		String birthday = userValidator.getBirthday();
		String isChoseOld = userValidator.getIsChoseOld();
		String companyName = userValidator.getCompanyName();
		String companyEmail = userValidator.getCompanyEmail();
		String companyAddress = userValidator.getCompanyAddress();
		String companyTel = userValidator.getCompanyTel();
		String placeRegister = userValidator.getPlaceRegister();
		String startDate = userValidator.getStartDate();
		String endDate = userValidator.getEndDate();
		String companyId = userValidator.getCompanyId();
		errors = new ArrayList<String>();
		String INSURANCE_PATTERN = "^\\d*$";
		//Kiểm tra mã số bảo hiểm
		if (Common.isEmpty(insuranceCode)) {
			errors.add(MessageErrorProperties.getMessage("EMPTY_INSURANCE_CODE"));
		} else if (!Pattern.matches(INSURANCE_PATTERN, insuranceCode)){
			errors.add(MessageErrorProperties.getMessage("FORMAT_INSURANCE_CODE"));
		} else if (insuranceCode.length() > 10) {
			errors.add(MessageErrorProperties.getMessage("MAXLENGTH_INSURANCE_CODE"));
		} else if (insuranceService.isExistByCodeAndId(insuranceCode, insuranceId)) {
			errors.add(MessageErrorProperties.getMessage("EXIST_INSURANCE_CODE"));
		}
		//Kiểm tra fullName
		if (Common.isEmpty(fullName)) {
			errors.add(MessageErrorProperties.getMessage("EMPTY_FULLNAME"));
		} else if (fullName.length() > 50) {
			errors.add(MessageErrorProperties.getMessage("MAXLENGTH_FULLNAME"));
		}
		//Kiểm tra ngày sinh khi nhập
		if (!Common.isEmpty(birthday)) {
			if (!Common.isRightFormat(birthday)) {
			errors.add(MessageErrorProperties.getMessage("FORMAT_BIRTHDAY"));
			} else if (!Common.isValidDate(birthday)) {
			errors.add(MessageErrorProperties.getMessage("EXIST_BIRTHDAY"));
			}
		}
		//Khi người dùng chọn tạo company mới
		boolean isChoosen = Boolean.parseBoolean(isChoseOld);
		if (!isChoosen) {
			//Kiểm tra cho company
			//Kiểm tra companyName
			if (Common.isEmpty(companyName)) {
				errors.add(MessageErrorProperties.getMessage("EMPTY_COMPANY_NAME"));
			} else if (companyName.length() > 50) {
				errors.add(MessageErrorProperties.getMessage("MAXLENGTH_COMPANY_NAME"));
			}
			//Kiểm tra companyAddress
			if (Common.isEmpty(companyAddress)) {
				errors.add(MessageErrorProperties.getMessage("EMPTY_COMPANY_ADDRESS"));
			} else if (companyAddress.length() > 50) {
				errors.add(MessageErrorProperties.getMessage("MAXLENGTH_COMPANY_ADDRESS"));
			}
			//Kiểm tra email khi nhập
			if (!Common.isEmpty(companyEmail)) {
				String EMAIL_PATTERN =
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				if(!Pattern.matches(EMAIL_PATTERN, companyEmail)) {
					errors.add(MessageErrorProperties.getMessage("FORMAT_COMPANY_EMAIL"));
				} else if (companyEmail.length() > 50) {
					errors.add(MessageErrorProperties.getMessage("MAXLENGTH_COMPANY_EMAIL"));
				}
			}
			//Kiểm tra số điện thoại khi nhập
			if (!Common.isEmpty(companyTel)) {
				String TEL_PATTERN = "^0\\d+$";
				if(!Pattern.matches(TEL_PATTERN, companyTel)) {
					errors.add(MessageErrorProperties.getMessage("FORMAT_COMPANY_TEL"));
				} else if (companyTel.length() > 15) {
					errors.add(MessageErrorProperties.getMessage("MAXLENGTH_COMPANY_TEL"));
				}
			}
		} else {
			//Kiểm tra công ty chọn có tồn tại hay không
			if (companyService.getCompanyById(Integer.parseInt(companyId)) == null) {
				errors.add(MessageErrorProperties.getMessage("EXIST_COMPANY"));
			}
		}
		//Kiểm tra nơi đăng ký KCB
		if (Common.isEmpty(placeRegister)) {
			errors.add(MessageErrorProperties.getMessage("EMPTY_INSURANCE_PLACE_REGISTER"));
		} else if (placeRegister.length() > 50) {
			errors.add(MessageErrorProperties.getMessage("MAXLENGTH_INSURANCE_PLACE_REGISTER"));
		}
		//Kiểm tra ngày bắt đầu
		if (Common.isEmpty(startDate)) {
			errors.add(MessageErrorProperties.getMessage("EMPTY_STARTDATE"));
		}  else if (!Common.isRightFormat(startDate)) {
			errors.add(MessageErrorProperties.getMessage("FORMAT_STARTDATE"));
		} else if (!Common.isValidDate(startDate)) {
			errors.add(MessageErrorProperties.getMessage("EXIST_STARTDATE"));
		}
		//Kiểm tra ngày kết thúc
		if (Common.isEmpty(endDate)) {
			errors.add(MessageErrorProperties.getMessage("EMPTY_ENDDATE"));
		} else if (!Common.isRightFormat(endDate)) {
			errors.add(MessageErrorProperties.getMessage("FORMAT_ENDDATE"));
		} else if (!Common.isValidDate(endDate)) {
			errors.add(MessageErrorProperties.getMessage("EXIST_ENDDATE"));
		}
		//Kiểm tra ngày bắt đầu có trước ngày kết thúc hay không
		if (Common.isValidDate(startDate) && Common.isValidDate(endDate)) {
			if (Common.toDate(startDate).getTime() >= Common.toDate(endDate).getTime() ) {
				errors.add(MessageErrorProperties.getMessage("START_AFTER_ENDDATE"));
			}
		}
		if (errors.size() == 0) return true;
		else return false;
	}
	@Autowired
	InsuranceService insuranceService;
	@Autowired
	CompanyService companyService;
}
