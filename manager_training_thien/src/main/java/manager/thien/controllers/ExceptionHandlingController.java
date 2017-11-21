/**
 * Copyright(C) 2016 Luvina Software Company
 * ExceptionHandlingController.java Sep 19, 2016 nguyenducthien
 */
package manager.thien.controllers;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import manager.thien.utils.Constant;

/**
 * Dùng để xử lý exception
 * @author nguyenducthien
 *
 */
@ControllerAdvice
public class ExceptionHandlingController {

	/**
	 * Xử lý khi gặp lỗi database
	 * @return màn hình thông báo lỗi Database
	 */
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView databaseError() {
		ModelAndView model = new ModelAndView();
		String error = "Database gặp lỗi";
		model.addObject("error", error);
		model.setViewName(Constant.SYSTEM_ERROR);
		return model;
	}
	/**
	 * Dùng đẻ xử lý gặp lỗi
	 * @return màn hình thông báo lỗi
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionError() {
		ModelAndView model = new ModelAndView();
		String error = "Hệ thống đang gặp lỗi";
		model.addObject("error", error);
		model.setViewName(Constant.SYSTEM_ERROR);
		return model;
	}
	
}
