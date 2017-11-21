/**
 * Copyright(C) 2016 Luvina Software Company
 * Insurance.java Sep 9, 2016 nguyenducthien
 */
package manager.thien.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Insurance dùng cho tbl_insurance
 * @author nguyenducthien
 *
 */
@Entity
@Table(name="tbl_insurance")
public class Insurance {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insurance_internal_id")
	private int id;
	@Column(name = "insurance_number")
	private String code;
	@Column(name = "insurance_start_date")
	private Date startDate;
	@Column(name = "insurance_end_date")
	private Date endDate;
	@Column(name = "place_of_register")
	private String placeRegister;
	/**
	 * Default constructor
	 */
	public Insurance(){}
	/**
	 * @param id
	 * @param code
	 * @param startDate
	 * @param endDate
	 * @param placeRegister
	 */
	public Insurance(int id, String code, Date startDate, Date endDate, String placeRegister) {
		super();
		this.id = id;
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		this.placeRegister = placeRegister;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
}
