/**
 * Copyright(C) 2016 Luvina Software Company
 * ViewUserDetailController.java Sep 13, 2016 nguyenducthien
 */
package manager.thien.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import manager.thien.models.User;
import manager.thien.services.CompanyService;
import manager.thien.services.UserService;
import manager.thien.utils.Constant;

/**
 * Dùng để xem chi tiết user
 * @author nguyenducthien
 *
 */
@Controller
public class ViewDetailUserController {
	@Autowired
	UserService userService;
	@Autowired
	CompanyService companyService;
	/**
	 * Dùng để xem chi tiết user bằng id
	 * @param userId int id của user đó
	 * @param tabID String tabcode
	 * @return màn hình xem chi tiết ADM003
	 */
	@RequestMapping(value="/viewDetailUser", method = RequestMethod.GET)
	public ModelAndView showDetailUser(int userId, String tabID) {
		ModelAndView model = new ModelAndView();
		User user = userService.getUserById(userId);
		model.addObject("user", user);
		model.addObject("tabID", tabID);
		model.setViewName(Constant.ADM003);
		return model;
	}
	/**
	 * Dùng để xóa một user bằng id
	 * @param userId int id từ request
	 * @return nếu xóa thành công thì trả về trang ADM002 
	 */
	@RequestMapping(value="/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUserById(int userId) {
		ModelAndView model = new ModelAndView();
		int companyId = userService.getUserById(userId).getCompany().getId();
		if (userService.deleteUserById(userId)) {
			model.setViewName("redirect:listUsers?companyId=" + companyId);
		} else {
			model.setViewName(Constant.SYSTEM_ERROR);
		}
		return model;
	}
}
