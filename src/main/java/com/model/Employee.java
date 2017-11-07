package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 作者：roll27
 * @version 创建时间：2017年11月7日下午4:07:53 类说明
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = -3585474348351746547L;

	private long id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private int salaryLevel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getSalaryLevel() {
		return salaryLevel;
	}

	public void setSalaryLevel(int salaryLevel) {
		this.salaryLevel = salaryLevel;
	}

}
