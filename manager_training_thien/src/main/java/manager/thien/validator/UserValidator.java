/**
 * Copyright(C) 2016 Luvina Software Company
 * UserValidator.java Sep 14, 2016 nguyenducthien
 */
package manager.thien.validator;

import org.springframework.stereotype.Component;

/**
 * Dùng để lưu thông tin của user dùng cho validate
 * @author nguyenducthien
 *
 */
@Component
public class UserValidator {
	private String id;
	private String insuranceCode;
	private String insuranceId;
	private String fullName;
	private String sex;
	private String birthday;
	private String isChoseOld;
	private String placeRegister;
	private String startDate;
	private String endDate;
	private String companyId;
	private String companyName;
	private String companyAddress;
	private String companyEmail;
	private String companyTel;
	/**
	 * @param id
	 * @param insuranceCode
	 * @param insuranceId 
	 * @param fullName
	 * @param sex
	 * @param birthday
	 * @param isChoseOld
	 * @param placeRegister
	 * @param startDate
	 * @param endDate
	 * @param companyId
	 * @param companyName
	 * @param companyAddress
	 * @param companyEmail
	 * @param companyTel
	 */
	public UserValidator(String id, String insuranceCode, String insuranceId, String fullName, String sex, String birthday,
			String isChoseOld, String placeRegister, String startDate, String endDate, String companyId,
			String companyName, String companyAddress, String companyEmail, String companyTel) {
		super();
		this.id = id;
		this.insuranceCode = insuranceCode;
		this.insuranceId = insuranceId;
		this.fullName = fullName;
		this.sex = sex;
		this.birthday = birthday;
		this.isChoseOld = isChoseOld;
		this.placeRegister = placeRegister;
		this.startDate = startDate;
		this.endDate = endDate;
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyEmail = companyEmail;
		this.companyTel = companyTel;
	}
	/**
	 * 
	 */
	public UserValidator(){}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the insuranceCode
	 */
	public String getInsuranceCode() {
		return insuranceCode;
	}
	/**
	 * @param insuranceCode the insuranceCode to set
	 */
	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the isChoseOld
	 */
	public String getIsChoseOld() {
		return isChoseOld;
	}
	/**
	 * @param isChoseOld the isChoseOld to set
	 */
	public void setIsChoseOld(String isChoseOld) {
		this.isChoseOld = isChoseOld;
	}
	/**
	 * @return the placeRegister
	 */
	public String getPlaceRegister() {
		return placeRegister;
	}
	/**
	 * @param placeRegister the placeRegister to set
	 */
	public void setPlaceRegister(String placeRegister) {
		this.placeRegister = placeRegister;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * @return the companyEmail
	 */
	public String getCompanyEmail() {
		return companyEmail;
	}
	/**
	 * @param companyEmail the companyEmail to set
	 */
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	/**
	 * @return the companyTel
	 */
	public String getCompanyTel() {
		return companyTel;
	}
	/**
	 * @param companyTel the companyTel to set
	 */
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	/**
	 * @return the insuranceId
	 */
	public String getInsuranceId() {
		return insuranceId;
	}
	/**
	 * @param insuranceId the insuranceId to set
	 */
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
}
