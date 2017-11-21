/**
 * Copyright(C) 2016 Luvina Software Company
 * InsuranceService.java Sep 9, 2016 nguyenducthien
 */
package manager.thien.services;


import manager.thien.models.Insurance;

/**
 * Interface Service cho Insurance
 * @author nguyenducthien
 *
 */
public interface InsuranceService {
	/**
	 * Dùng để lấy một Insurance bằng Id
	 * @param id int
	 * @return Insurance
	 */
	Insurance getInsuranceById(int id);
	/**
	 * Dùng để kiểm tra mã bảo hiểm có tồn tại trừ bảo hiểm có id 
	 * @param code String mã bảo hiểm muốn kiểm tra
	 * @param id int id của bảo hiểm
	 * @return true nếu tồn tại
	 */
	Boolean isExistByCodeAndId(String code, int id);
}
