/**
 * Copyright(C) 2016 Luvina Software Company
 * Company.java Sep 8, 2016 nguyenducthien
 */
package manager.thien.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class cho table tbl_company
 * @author nguyenducthien
 *
 */
@Entity
@Table(name="tbl_company")
public class Company {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_internal_id")
	private int id;
	@Column(name = "company_name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "telephone")
	private String tel;
	
	/**
	 * Default constructor
	 */
	public Company(){}
	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param email
	 * @param tel
	 */
	public Company(int id, String name, String address, String email, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.tel = tel;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
