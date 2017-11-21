/**
 * Copyright(C) 2016 Luvina Software Company
 * ExportCSV.java Sep 19, 2016 nguyenducthien
 */
package manager.thien.controllers;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import manager.thien.models.Company;
import manager.thien.models.User;
import manager.thien.services.CompanyService;
import manager.thien.services.UserService;
import manager.thien.utils.Common;
import manager.thien.utils.MessageProperties;

/**
 * Dùng để export file CSV
 * @author nguyenducthien
 *
 */
@Controller
public class ExportCSV {

	@Autowired
	UserService userService;
	@Autowired
	CompanyService companyService;
	/**
	 * Dùng để export file CSV
	 * @param response http
	 * @param session 
	 * @param tabID mã tab dùng để lấy điều kiện tìm kiếm để export
	 * @throws Exception 
	 */
	@RequestMapping(value = "/exportListUserToCSV",method=RequestMethod.GET)
   public void exportListUserToCSV(HttpServletResponse response,HttpSession session,  String tabID) throws Exception {
		//Nếu lấy được tabID để export và có dữ liệu trên session
		if (tabID != null && session.getAttribute("companyId" + tabID) != null) {
			//Lấy điều kiện tìm kiếm để export CSV
			String companyId = session.getAttribute("companyId" + tabID).toString();
			String fullNameKey = session.getAttribute("fullNameKey" + tabID).toString();
			String insuranceCodeKey = session.getAttribute("insuranceCodeKey" + tabID).toString();
			String insurancePlaceRegisterKey = session.getAttribute("insurancePlaceRegisterKey" + tabID).toString();
			String sort = session.getAttribute("sort" + tabID).toString();
			Company company = companyService.getCompanyById(Integer.parseInt(companyId));
			//Đặt nội dung file CSV
			String fileName = "listUser";
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+".csv\"");
			String commas = ",";
			//String header = MessageProperties.getMessage("HEADER_EXPORT_CSV_ADM002");
			StringBuilder header = new StringBuilder();
			header.append(MessageProperties.getMessage("COMPANY_NAME") + commas + company.getName() + "\n");
			header.append(MessageProperties.getMessage("ADDRESS") + commas + company.getAddress() + "\n");
			header.append( MessageProperties.getMessage("EMAIL") + commas + ((company.getEmail() != null) ? company.getEmail(): "") + "\n");
			header.append( MessageProperties.getMessage("PHONE") + commas + ((company.getTel() != null) ? company.getTel() : "") + "\n");
			StringBuilder title = new StringBuilder();
			title.append(MessageProperties.getMessage("FULL_NAME") + commas);
			title.append(MessageProperties.getMessage("SEX") + commas);
			title.append(MessageProperties.getMessage("BIRTHDAY_USER") + commas);
			title.append(MessageProperties.getMessage("INSURANCE_CODE") + commas);
			title.append(MessageProperties.getMessage("INSURANCE_START_DATE") + commas);
			title.append(MessageProperties.getMessage("INSURANCE_END_DATE") + commas);
			title.append(MessageProperties.getMessage("INSURANCE_PLACE_REGISTER") + commas + "\n");
			int PAGE_SIZE = 1000;
			int page = 0;
			int total = userService.countTotalUserByCondition(Integer.parseInt(companyId),
					fullNameKey,
					insuranceCodeKey,
					insurancePlaceRegisterKey);
			int totalPage = Common.getTotalPage(total, PAGE_SIZE);
			List<User> listUser ;
			OutputStream out;
			out = response.getOutputStream();
			try {
				//Cho excel đọc định dạng UTF-8 default
				byte[] bom = { (byte) 239, (byte) 187, (byte) 191 };
				out.write(bom);
				Common.writeOutputStreamAndFlush(out, MessageProperties.getMessage("LIST_INSURANCE") + "\n\n");
				Common.writeOutputStreamAndFlush(out, header.toString());
				Common.writeOutputStreamAndFlush(out, title.toString());
				//Lấy listUser 1000 bản ghi 1 lần để print để tránh OutOfMemory
				do {
					listUser = userService.getPagingListUser(Integer.parseInt(companyId),
							fullNameKey,
							insuranceCodeKey,
							insurancePlaceRegisterKey,
							page,
							PAGE_SIZE,
							sort);
					String body = Common.getBodyCSVForListUser(listUser, ",");
					Common.writeOutputStreamAndFlush(out, body);
					page++;
				} while (page <= totalPage);
			} finally {
				out.close();
			}
		} else {
			throw new Exception();
		}
	}
}
