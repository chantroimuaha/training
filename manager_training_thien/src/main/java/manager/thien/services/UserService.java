/**
 * Copyright(C) 2016 Luvina Software Company
 * UserService.java Sep 9, 2016 nguyenducthien
 */
package manager.thien.services;

import java.util.List;

import manager.thien.models.User;

/**
 * Interface Service cho User
 * @author nguyenducthien
 *
 */
public interface UserService {


	/**
	 * Dùng để lấy danh sách user cho paging
	 * @param companyId int id của company
	 * @param fullName String tên mà người sử dụng tìm kiếm
	 * @param insuranceCode String mã bảo hiểm mà người sử dụng tìm kiếm
	 * @param insurancePlaceRegister String nơi mà người sử dụng tìm kiếm
	 * @param page int trang hiện tại
	 * @param size int số lượng user trên 1 page
	 * @param sort String tăng hay giảm
	 * @return trả lại một List<User>
	 */
	List<User> getPagingListUser(int companyId, String fullName, String insuranceCode, String insurancePlaceRegister,
			 int page, int size, String sort) ;
	/**
	 * Dùng để lấy tổng số lượng User cho paging
	 * @param companyId int id của company
	 * @param fullName String tên của User
	 * @param insuranceCode String code của bảo hiểm
	 * @param insurancePlaceRegister String nơi đăng ký bảo hiểm
	 * @return int tổng số bảo ghi thỏa mãn
	 */
	int countTotalUserByCondition(int companyId,String fullName,String insuranceCode,String insurancePlaceRegister);
	/**
	 * Dùng để tìm User bằng id
	 * @param id int id của User
	 * @return User cần tìm 
	 */
	User getUserById(int id);
	/**
	 * Dùng để lưu một user
	 * @param user User
	 * @return true nếu lưu thành công
	 */
	boolean saveUser(User user);
	/**
	 * Dùng để xóa user bằng id
	 * @param id int
	 * @return True nếu xóa thành công
	 */
	boolean deleteUserById(int id);
	/**
	 * Dùng để lấy tất cả các bản ghi trong User
	 * @return List<User>
	 */
	public List<User> getAllUser();
	/** 
	 * Dùng để tính tổng user
	 * @return tổng số lượng user
	 */
	public int countTotalUser();
	/**
	 * Dùng để lấy List<User> theo số lượng
	 * @param size tổng số user muốn lấy / page
	 * @param page số page muốn lấy
	 * @return List<User>
	 */
	public List<User> getListUserBySize(int size, int page);
}
