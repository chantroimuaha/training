/**
 * Copyright(C) 2016 Luvina Software Company
 * UserRepository.java Sep 12, 2016 nguyenducthien
 */
package manager.thien.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import manager.thien.models.User;

/**
 * @author nguyenducthien
 *
 */
public interface UserRepository extends JpaRepository<User, Integer>{

	/**
	 * Dùng để lấy một Page danh sách user
	 * @param companyId int id của company
	 * @param fullName String key fullName
	 * @param insuranceCode String key insuranceCode
	 * @param insurancePlaceRegister String key placeRegister
	 * @param pageRequest PagingRequest chứa xắp xếp,size,
	 * @return Trả về 1 Page 
	 */
	/*@Query("select u from User u where u.company.id = ?1 and u.fullName LIKE %?2% and u.insurance.code like %?3% and u.insurance.placeRegister like %?4%")
	Page<User> getPagingListUser(int companyId,String fullName,String insuranceCode,String insurancePlaceRegister,Pageable pageRequest);*/
	@Query("select u from User u where u.company.id = :companyId and u.fullName LIKE %:fullName% and u.insurance.code like %:insuranceCode% and u.insurance.placeRegister like %:insurancePlaceRegister%")
	Page<User> getPagingListUser(@Param("companyId")int companyId, @Param("fullName")String fullName, @Param("insuranceCode")String insuranceCode,@Param("insurancePlaceRegister") String insurancePlaceRegister,Pageable pageRequest);
	/**
	 * Dùng để lấy tổng số User theo điều kiện tìm kiếm
	 * @param companyId int id của company
	 * @param fullName String key fullName
	 * @param insuranceCode String insuranceCode
	 * @param insurancePlaceRegister String placeRegister
	 * @return int tổng số user thỏa mãn
	 */
	@Query("select COUNT(u) from User u where u.company.id = ?1 and u.fullName like %?2% and u.insurance.code like %?3% and u.insurance.placeRegister like %?4%")
	int countTotalUserByCondition(int companyId,String fullName,String insuranceCode,String insurancePlaceRegister);
}
