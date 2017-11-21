/**
 * Copyright(C) 2016 Luvina Software Company
 * UserServiceImpl.java Sep 9, 2016 nguyenducthien
 */
package manager.thien.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import manager.thien.models.User;
import manager.thien.repository.CompanyRepository;
import manager.thien.repository.InsuranceRepository;
import manager.thien.repository.UserRepository;
import manager.thien.utils.Constant;

/**
 * Implement inteface UserService
 * @author nguyenducthien
 *
 */
	@Service
public class UserServiceImpl implements UserService{

	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	InsuranceRepository insuranceRepository;
	/* (non-Javadoc)
	 * @see manager.thien.services.UserService#getPagingListUser(int, java.lang.String, int, java.lang.String, int, int)
	 */
	@Override
	public List<User> getPagingListUser(int companyId, String fullName, String insuranceCode, String insurancePlaceRegister,
			 int page, int size, String sort) {
		Sort fullNameSort;
		if ((Constant.DESC).equals(sort)) {
			fullNameSort = new Sort(Sort.Direction.DESC, "fullName");
		} else {
			fullNameSort = new Sort(Sort.Direction.ASC, "fullName");
		}
		Pageable pageRequest = new PageRequest(page, size,fullNameSort);
		Page<User> pageList = userRepository.getPagingListUser(companyId, fullName, insuranceCode, insurancePlaceRegister, pageRequest);
			return pageList.getContent();
	}

	/* (non-Javadoc)
	 * @see manager.thien.services.UserService#getTotalUser(int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int countTotalUserByCondition(int companyId, String fullName, String insuranceCode, String insurancePlaceRegister) {
		return userRepository.countTotalUserByCondition(companyId, fullName, insuranceCode, insurancePlaceRegister);
	}

	/* (non-Javadoc)
	 * @see manager.thien.services.UserService#getUserById(int)
	 */
	@Override
	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see manager.thien.services.UserService#saveUser(manager.thien.models.User)
	 */
	@Override
	@Transactional
	public boolean saveUser(User user) {
		if (companyRepository.save(user.getCompany()) == null) return false;
		if (insuranceRepository.save(user.getInsurance()) == null) return false;
		if (userRepository.save(user) == null) return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see manager.thien.services.UserService#deleteUserById(int)
	 */
	@Override
	@Transactional
	public boolean deleteUserById(int id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return false;
		} else {
			int insuranceId = user.getInsurance().getId();
			userRepository.delete(id);
			insuranceRepository.delete(insuranceId);
			if (userRepository.exists(id) || insuranceRepository.exists(insuranceId)) {
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see manager.thien.services.UserService#getAllUser()
	 */
	@Override
	public List<User> getAllUser() {
		Sort sortByName = new Sort(Direction.ASC,"fullName");
		return userRepository.findAll(sortByName);
	}

	/* (non-Javadoc)
	 * @see manager.thien.services.UserService#countTotalUser()
	 */
	@Override
	public int countTotalUser() {
		return (int)userRepository.count();
	}

	/* (non-Javadoc)
	 * @see manager.thien.services.UserService#getListUserBySize(int)
	 */
	@Override
	public List<User> getListUserBySize(int size, int page) {
		Sort fullNameSort = new Sort(Sort.Direction.ASC, "fullName");
		Pageable pageRequest = new PageRequest(page, size,fullNameSort);
		List<User> listUser = userRepository.findAll(pageRequest).getContent();
		return listUser;
	}
	

}
