/**
 * Copyright(C) 2016 Luvina Software Company
 * ListUsers.java Sep 8, 2016 nguyenducthien
 */
package manager.thien.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import manager.thien.models.Company;
import manager.thien.models.User;
import manager.thien.services.CompanyService;
import manager.thien.services.UserService;
import manager.thien.utils.Common;
import manager.thien.utils.Constant;
/**
 * Dùng để xử lý cho màn hình ADM002
 * @author nguyenducthien
 *
 */
@Controller
public class ListUsersController {

	/**
	 * Tạo mã cho tab khi mở nhiều tab cùng một lúc
	 */
	public int code = 0;
	@Autowired
	CompanyService companyService;
	@Autowired
	UserService userService;
	/**
	 * Dùng để xử lý các trường hợp:
	 * 1, Lần đầu tiên vào doGet
	 * 2, Sorting doGet
	 * 3, Paging doGet
	 * 4, NotChange doGet
	 * 5, Searching doPost
	 * @param companyId String parametter
	 * @param fullNameKey String parametter
	 * @param insuranceCodeKey String parameter
	 * @param insurancePlaceRegisterKey String parametter
	 * @param page String parameter
	 * @param sort String parameter
	 * @param session String parameter
	 * @param notChange String parameter
	 * @param tabID String parameter
	 * @return màn hình hiển thị
	 */
	@RequestMapping(value = "/listUsers")
	public ModelAndView viewListUser( 
			String companyId,  
			String fullNameKey, 
			String insuranceCodeKey,
			String insurancePlaceRegisterKey,
			String page,
			String sort,
			HttpSession session, 
			String notChange, 
			String tabID) {
		//Lấy danh sách company
		List<Company> listCompany = companyService.getAllCompany();
		//Kiểm tra xem thông tin lưu trên session còn hay không để biết được đó là lần đầu tiền vào màn hình
		boolean haveSession = (session.getAttribute("companyId" + tabID) != null) ? true : false;
		//Nếu không nhận được tabID hoặc không có session trước thì sẽ tạo mã tabID cho màn hình đó
		if (Common.isEmpty(tabID) || !haveSession) {
			tabID = code++ + "";
		} 
		//Kiểm tra khi nào sorting, paging, notChanging
		boolean isSorting = (haveSession && sort != null) ? true : false;
		boolean isPaging = (haveSession && page != null) ? true : false;
		boolean isNotChanging = (haveSession && notChange != null) ? true : false;
		//Thông tin để hiển thị cho table
		List<User> listUser;
		//Khai báo thông tin paging
		int totalPage;
		int totalRecord;
		List<Integer> listPage;
		//Đặt giá trị mặc định cho thông tin tìm kiếm
		companyId = (!Common.isEmpty(companyId)) ? companyId : ((listCompany.size() > 0) ? listCompany.get(0).getId() + "" : "0");
		fullNameKey = (fullNameKey != null) ? fullNameKey : "";
		insuranceCodeKey = (insuranceCodeKey != null) ? insuranceCodeKey : "";
		insurancePlaceRegisterKey = (insurancePlaceRegisterKey != null) ? insurancePlaceRegisterKey : "";
		sort = ((Constant.DESC).equals(sort)) ? sort : Constant.ASC;
		page = (page != null) ? page : "1";
		//Lấy từ session khi Sorting, Paging, NotChange
		if (isSorting || isPaging || isNotChanging) {
			companyId = session.getAttribute("companyId" + tabID).toString();
			fullNameKey = session.getAttribute("fullNameKey" + tabID).toString();
			insuranceCodeKey = session.getAttribute("insuranceCodeKey" + tabID).toString();
			insurancePlaceRegisterKey = session.getAttribute("insurancePlaceRegisterKey" + tabID).toString();
			sort = (isPaging || isNotChanging) ? session.getAttribute("sort" + tabID).toString():sort;
			page = (isNotChanging) ? session.getAttribute("page" + tabID).toString() : page;
		}
		//Hiển thị table và paging
		int id = Integer.parseInt(companyId);
		int currentPage = Integer.parseInt(page);
		//Lấy List<User> để hiển thị trên table
		listUser = userService.getPagingListUser(id,
				Common.sqlEscapeLike(fullNameKey),
				Common.sqlEscapeLike(insuranceCodeKey),
				Common.sqlEscapeLike(insurancePlaceRegisterKey),
				currentPage - 1,
				Constant.PAGE_SIZE, sort);
		//Lấy tổng số bản ghi để tính paging
		totalRecord = userService.countTotalUserByCondition(id,
				Common.sqlEscapeLike(fullNameKey),
				Common.sqlEscapeLike(insuranceCodeKey),
				Common.sqlEscapeLike(insurancePlaceRegisterKey));
		totalPage = Common.getTotalPage(totalRecord, Constant.PAGE_SIZE);
		listPage = Common.getListPage(totalPage, currentPage, Constant.PAGE_NUMBER);
		//Tính số hàng trống còn lại nếu tại currentPage nhỏ hơn PAGE_SIZE < 5
		List<String> listEmpty = Common.getListEmpty(listUser, Constant.PAGE_SIZE);
		ModelAndView model = new ModelAndView();
        //Dữ liệu logic
		model.addObject("listEmpty", listEmpty);
        model.addObject("listCompany", listCompany);
        //Đặt tất cả thông tin tìm kiếm lên model
		model.addObject("companyId", companyId);
		model.addObject("fullNameKey", fullNameKey);
		model.addObject("insuranceCodeKey", insuranceCodeKey);
		model.addObject("insurancePlaceRegisterKey", insurancePlaceRegisterKey);
		model.addObject("sort", sort);
		//Dành cho table
		model.addObject("listUser",listUser);
		//Dành cho paging
		model.addObject("PAGE_NUMBER", Constant.PAGE_NUMBER);
		model.addObject("listPage", listPage);
		model.addObject("totalPage", totalPage);
		model.addObject("page", currentPage);
		model.addObject("tabID",tabID);
		//Đặt tất cả thông tin tìm kiếm lên session
		session.setAttribute("companyId" + tabID, companyId);
		session.setAttribute("fullNameKey" + tabID, fullNameKey);
		session.setAttribute("insuranceCodeKey" + tabID, insuranceCodeKey);
		session.setAttribute("insurancePlaceRegisterKey" + tabID, insurancePlaceRegisterKey);
		session.setAttribute("sort" + tabID, sort);
		session.setAttribute("page" + tabID, currentPage);
		model.setViewName(Constant.ADM002);
		return model;
	}
}
