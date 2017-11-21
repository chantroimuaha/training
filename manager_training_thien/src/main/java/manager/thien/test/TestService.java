/**
 * Copyright(C) 2016 Luvina Software Company
 * TestService.java Sep 20, 2016 nguyenducthien
 */
package manager.thien.test;

import java.util.List;

import manager.thien.models.User;

/**
 * @author nguyenducthien
 *
 */
public interface TestService {
	User getAnUser(String i);
	List<User> getListUser(int number);
	void saveAllUser(List<User> listUser);
	void test();
}
