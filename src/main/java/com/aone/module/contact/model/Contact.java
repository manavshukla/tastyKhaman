package com.aone.module.contact.model;




import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.address.model.Address;
import com.aone.module.contact.constant.ContactDbColPojoConstant;
import com.aone.module.contactCategory.model.ContactCategory;
import com.aone.module.userRole.model.UserRole;
import com.aone.module.userRoleGroupMapping.model.UserRoleGroupMapping;


/**
 * The Class Contact.
 */
@Entity
@Table(name = "contact_master")
public class Contact extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -5483791619804079369L;

	@Column(name = ContactDbColPojoConstant.FNAME)
	private String fname;
	
	@Column(name = ContactDbColPojoConstant.LNAME)
	private String lname;
	
	@Column(name = ContactDbColPojoConstant.USER_NAME, length = 255)
	private String userName;
	
	@Column(name = ContactDbColPojoConstant.EMAIL)
	private String email;
	
	@Column(name = ContactDbColPojoConstant.PHONE)
	private String phone;
	
	@Column(name = ContactDbColPojoConstant.MOBILE)
	private String mobile;
	
	@Column(name = ContactDbColPojoConstant.CONTACT_TYPE)
	private String contactType;
	
	@Column(name = ContactDbColPojoConstant.CONTACT_CATEGORY_ID)
	private long contactCategoryId;
	
	@Column(name = ContactDbColPojoConstant.DESCRIPTION)
	private String description;
	
	@Column(name = ContactDbColPojoConstant.VEHICLENUMBER)
	private String vehicleNo;
	
	@Column(name = ContactDbColPojoConstant.PASSWORD_HASH, length = 100)
	@Size(message = "user.validation.password.size")
	private String passwordHash;
	
	@Transient
	private Address billingAddress;
	
	@Transient
	private ContactCategory contactCategory; 
	
	@Transient
	private ContactInitData contactInitData;

	@Transient
	private List<UserRoleGroupMapping> userRoleGroupMappingList;
	
	@Transient
	private List<UserRole> userRoleList;
	
	
	public String getVehicleNo() {
		return vehicleNo;
	}


	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}



	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getContactType() {
		return contactType;
	}


	public void setContactType(String contactType) {
		this.contactType = contactType;
	}


	public long getContactCategoryId() {
		return contactCategoryId;
	}


	public void setContactCategoryId(long contactCategoryId) {
		this.contactCategoryId = contactCategoryId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public ContactInitData getContactInitData() {
		return contactInitData;
	}

	public void setContactInitData(ContactInitData contactInitData) {
		this.contactInitData = contactInitData;
	}
	
	public ContactCategory getContactCategory() {
		return contactCategory;
	}

	public void setContactCategory(ContactCategory contactCategory) {
		this.contactCategory = contactCategory;
	}

	public List<UserRoleGroupMapping> getUserRoleGroupMappingList() {
		return userRoleGroupMappingList;
	}

	public void setUserRoleGroupMappingList(List<UserRoleGroupMapping> userRoleGroupMappingList) {
		this.userRoleGroupMappingList = userRoleGroupMappingList;
	}

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "Contact [fname=" + fname + ", lname=" + lname + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", mobile=" + mobile + ", contactType=" + contactType + ", contactCategoryId="
				+ contactCategoryId + ", description=" + description + ", vehicleNo=" + vehicleNo + ", passwordHash="
				+ passwordHash + ", billingAddress=" + billingAddress + ", contactCategory=" + contactCategory
				+ ", contactInitData=" + contactInitData + ", userRoleGroupMappingList=" + userRoleGroupMappingList
				+ ", userRoleList=" + userRoleList + "]";
	}	
}
