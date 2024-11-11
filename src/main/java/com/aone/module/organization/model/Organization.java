package com.aone.module.organization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.organization.constant.OrganizationDbColPojoConstant;

@Entity
@Table(name = "organization_master")
public class Organization extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = OrganizationDbColPojoConstant.FIRM_NAME)
	private String firmName;
	
	@Column(name = OrganizationDbColPojoConstant.ADDRESS)
	private String address;
	
	@Column(name = OrganizationDbColPojoConstant.CITY_ID)
	private long cityId;
	
	@Column(name = OrganizationDbColPojoConstant.STATE_ID)
	private long stateId;
	
	@Column(name = OrganizationDbColPojoConstant.COUNTRY_ID)
	private long countryId;
	
	@Column(name = OrganizationDbColPojoConstant.GST_IN_CODE)
	private String gstInCode;
	
	@Column(name = OrganizationDbColPojoConstant.OFFICE_NO)
	private String officeNo;
	
	@Column(name = OrganizationDbColPojoConstant.MOBILE_NO1)
	private String mobileNo1;
	
	@Column(name = OrganizationDbColPojoConstant.MOBILE_NO2)
	private String mobileNo2;
	
	@Column(name = OrganizationDbColPojoConstant.EMAIL_ID)
	private String emailId;
	
	@Column(name = OrganizationDbColPojoConstant.REGISTRATION_NUMBER)
	private String registrationNumber;
	
	@Column(name = OrganizationDbColPojoConstant.BANK_NAME)
	private String bankName;
	
	@Column(name = OrganizationDbColPojoConstant.ACCOUNT_NUMBER)
	private String accountNumber;
	
	@Column(name = OrganizationDbColPojoConstant.IFS_CODE)
	private String ifsCode;
	
	@Column(name = OrganizationDbColPojoConstant.BRANCH_NAME)
	private String branchName;
	
	@Column(name = OrganizationDbColPojoConstant.DESCRIPTION)
	private String description;
	
	public String getFirmName() {
		return firmName;
	}
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public String getGstInCode() {
		return gstInCode;
	}
	public void setGstInCode(String gstInCode) {
		this.gstInCode = gstInCode;
	}
	public String getOfficeNo() {
		return officeNo;
	}
	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}
	public String getMobileNo1() {
		return mobileNo1;
	}
	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}
	public String getMobileNo2() {
		return mobileNo2;
	}
	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfsCode() {
		return ifsCode;
	}
	public void setIfsCode(String ifsCode) {
		this.ifsCode = ifsCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Organization [firmName=" + firmName + ", address=" + address + ", cityId=" + cityId + ", stateId=" + stateId + ", countryId=" + countryId + ", gstInCode=" + gstInCode + ", officeNo=" + officeNo
				+ ", mobileNo1=" + mobileNo1 + ", mobileNo2=" + mobileNo2 + ", emailId=" + emailId + ", registrationNumber=" + registrationNumber + ", bankName=" + bankName + ", accountNumber=" + accountNumber + ", ifsCode="
				+ ifsCode + ", branchName=" + branchName + ", description=" + description + "]";
	}
	
}
