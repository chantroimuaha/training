/**
 * Copyright(C) 2016 Luvina Software Company
 * CompanyService.java Sep 8, 2016 nguyenducthien
 */
package manager.thien.services;

import java.util.List;

import manager.thien.models.Company;

/**
 * Interface xử lý liên quan đến class Company
 * @author nguyenducthien
 *
 */
public interface CompanyService {
	/**
	 * Dùng để trả về tất cả Company trong database tbl_company
	 * @return List<Company>
	 */
	/**
	 * Dùng để lấy một Company bằng Id
	 * @param id int
	 * @return Company theo Id
	 */
	Company getCompanyById(int id);
	/**
	 * Dùng để lấy tất cả Company
	 * @return List<Company>
	 */
	List<Company> getAllCompany();
}
