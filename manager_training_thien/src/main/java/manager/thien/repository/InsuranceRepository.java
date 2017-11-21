/**
 * Copyright(C) 2016 Luvina Software Company
 * InsuranceRepository.java Sep 14, 2016 nguyenducthien
 */
package manager.thien.repository;

import org.springframework.data.repository.CrudRepository;

import manager.thien.models.Insurance;

/**O
 * Tạo method xử lý cho insurance
 * @author nguyenducthien
 *
 */
public interface InsuranceRepository extends CrudRepository<Insurance, Integer>{

	/**
	 * Dùng để tìm Insurance bằng mã code
	 * @param code String mã bảo hiểm
	 * @param id int mã cần check
	 * @return Insurance
	 */
	Insurance findByCodeAndIdNot(String code, int id);
}
