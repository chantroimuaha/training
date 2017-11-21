/**
 * Copyright(C) 2016 Luvina Software Company
 * TestService.java Sep 20, 2016 nguyenducthien
 */
package manager.thien.test;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import manager.thien.models.Company;
import manager.thien.models.Insurance;
import manager.thien.models.User;
import manager.thien.repository.CompanyRepository;
import manager.thien.repository.InsuranceRepository;
import manager.thien.repository.UserRepository;
import manager.thien.utils.Common;

/**
 * Dùng để test, tạo dữ liệu demo
 * @author nguyenducthien
 *
 */
@Service
public class TestServiceImpl  implements TestService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired 
	InsuranceRepository insuranceRepository;
	@Transactional
	public void saveAllUser(List<User> listUser) {
		for (User user : listUser) {
			insuranceRepository.save(user.getInsurance());
			userRepository.save(user);
		}
	}
	@Override
	public User getAnUser(String i) {
		Company company = companyRepository.findOne(20);
		Insurance insurance = new Insurance();
		insurance.setId(0);
		insurance.setCode("0" + i);
		insurance.setEndDate(Common.toDate("12/03/1993"));
		insurance.setStartDate(Common.toDate("13/04/1990"));
		insurance.setPlaceRegister("Nam Dinh");
		User user = new User();
		user.setId(0);
		user.setFullName(Common.formattingName("Nguyen Duc Thien" + i));
		user.setBirthday(Common.toDate("15/03/1993"));
		user.setSex('1');
		user.setUserName(Common.getLoginName("Nguyen Duc Thien" + i));
		user.setPassword(Common.getMD5Password("Nguyen Duc Thien" + i));
		user.setCompany(company);
		user.setInsurance(insurance);
		return user;
	}
	@Override
	public List<User> getListUser(int number) {
		List<User> listUser = new ArrayList<User>();
		for (int i = 0; i < number; i++) {
			User user = getAnUser(i + "");
			listUser.add(user);
		}
		return listUser;
	}
	public void test() {

		int numberUser = 100000;
		try {
			int i = 100;
			do {
				List<User> listUser = getListUser(i);
				saveAllUser(listUser);
				i += 100;
			} while (i< numberUser);
		} catch(Exception ex) {
			System.out.println("not successfully");
			System.out.println(ex);
		}}
}
