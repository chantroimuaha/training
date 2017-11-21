/*
 * Copyright(C) 2010 Luvina Software Company
 *
 * ValidateUser.java, Oct 4, 2010 ntmhuong
 */
package net.luvina.manageuser.validates;

import java.util.ArrayList;
import java.util.List;

import net.luvina.manageuser.logics.impl.UserLogicImpl;
import net.luvina.manageuser.utils.MessageProperties;


/**
 * @author ntmhuong
 *
 */
public class ValidateUser {

	/**
	 * validateLogin
	 * @param loginId String loginId
	 * @param password String password
	 * @return list errorMess
	 */
	public static List<String> validateLogin(String loginId, String password) {
		List<String> lsErrorMess = new ArrayList<String>();
		if (loginId.trim().length() == 0) {
			lsErrorMess.add(MessageProperties.getMessage("error_001"));
		}
		if (password.length() == 0) {
			lsErrorMess.add(MessageProperties.getMessage("error_002"));
		}
		UserLogicImpl userLogic = new UserLogicImpl();
		if(loginId.trim().length() != 0 && password.length() != 0){
			//Start fix bug ID 38-ThienNguyen 2016/06/06
			if (!userLogic.existLoginId(loginId, password)) {
			//End fix bug ID 38-ThienNguyen 2016/06/06
				lsErrorMess.add(MessageProperties.getMessage("error_003"));
			}
		}

		return lsErrorMess;
	}
}
