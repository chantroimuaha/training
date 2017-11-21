/**
 * Copyright(C) 2016 Luvina Software Company
 * AjaxViewDetailCompanyController.java Sep 13, 2016 nguyenducthien
 */
package manager.thien.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import manager.thien.models.Company;
import manager.thien.services.CompanyService;

/**
 * Xử lý tất cả trường hợp lấy dữ liệu từ ajax
 * @author nguyenducthien
 *
 */
@Controller
public class AjaxController {

	@Autowired
	CompanyService companyService;
	/**
	 * Dùng để trả lại company bằng id
	 * @param id int id
	 * @return Object company tương ứng với id 
	 */
	@RequestMapping(value = "/getCompany",method=RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Company getCompany(int id) {
		return companyService.getCompanyById(id);
    }
}
