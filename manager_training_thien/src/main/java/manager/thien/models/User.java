/**
 * Copyright(C) 2016 Luvina Software Company
 * User.java Sep 9, 2016 nguyenducthien
 */
package manager.thien.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Model User cho bảng tbl_user
 * @author nguyenducthien
 *
 */
@Entity
@Table(name="tbl_user")
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_internal_id")
	private int id;
	@ManyToOne
	@JoinColumn(name="company_internal_id")
	private Company company;
	@OneToOne
	@JoinColumn(name="insurance_internal_id")
	private Insurance insurance;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="user_full_name")
	private String fullName;
	@Column(name="user_sex_division")
	private char sex;
	@Column(name="birthdate")
	private Date birthday;
	/**
	 * Default constructor
	 */
	public User(){}
	/**
	 * @param id int 
	 * @param company Company 
	 * @param insurance Insurance
	 * @param userName String
	 * @param password String
	 * @param fullName String
	 * @param sex Char
	 * @param birthday Date 
	 */
	public User(int id, Company company, Insurance insurance, String userName, String password, String fullName, char sex,
			Date birthday) {
		super();
		this.id = id;
		this.company = company;
		this.insurance = insurance;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.sex = sex;
		this.birthday = birthday;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	/**
	 * @return the insurance
	 */
	public Insurance getInsurance() {
		return insurance;
	}
	/**
	 * @param insurance the insurance to set
	 */
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	public char getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday 
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
