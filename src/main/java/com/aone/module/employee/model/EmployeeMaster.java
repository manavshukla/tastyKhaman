package com.aone.module.employee.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.employee.constant.EmployeeDbColmPojoConstant;

@Entity
@Table(name = "employee_master")
public class EmployeeMaster extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038293081990574066L;

	//Remove Address 1 AND 2 instead use Address Class.
	@Column(name=EmployeeDbColmPojoConstant.ADDRESS_1)
	private String address1;

	@Column(name=EmployeeDbColmPojoConstant.ADDRESS_2)
	private String address2;
	
	@Column(name=EmployeeDbColmPojoConstant.DATE_OF_BIRTH)
	private LocalDateTime dateOfBirth;
	
	@Column(name=EmployeeDbColmPojoConstant.DATE_OF_JOIN)
	private LocalDateTime dateOfJoin;
	
	@Column(name=EmployeeDbColmPojoConstant.DESIGNATION)
	private String designation;
	
	@Column(name=EmployeeDbColmPojoConstant.FIRST_NAME)
	private String firstName;
	
	@Column(name=EmployeeDbColmPojoConstant.LAST_NAME)
	private String lastName;

	@Column(name=EmployeeDbColmPojoConstant.MIDDLE_NAME)
	private String middleName;

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(LocalDateTime dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override
	public String toString() {
		return "Employee [address1=" + address1 + ", address2=" + address2 + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfJoin=" + dateOfJoin + ", designation=" + designation + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", middleName=" + middleName + "]";
	}
}
