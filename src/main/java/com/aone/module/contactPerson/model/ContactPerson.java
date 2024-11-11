package com.aone.module.contactPerson.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.contactPerson.constant.ContactPersonDbColPojoConstant;

/**
 * The Class Contact.
 */
@Entity
@Table(name = "contact_person_master")
public class ContactPerson extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 1348276899861927083L;

	@Column(name = ContactPersonDbColPojoConstant.SALUTATION)
	private long salutationId;
	
	@Column(name = ContactPersonDbColPojoConstant.FNAME)
	private String fname;
	
	@Column(name = ContactPersonDbColPojoConstant.LNAME)
	private String lname;
	
	@Column(name = ContactPersonDbColPojoConstant.EMAIL)
	private String email;
	
	@Column(name = ContactPersonDbColPojoConstant.PHONE)
	private String workPhone;
	
	@Column(name = ContactPersonDbColPojoConstant.MOBILE)
	private String mobile;
	
	@Column(name = ContactPersonDbColPojoConstant.CONTACT_ID)
	private long contactId;

	public long getSalutationId() {
		return salutationId;
	}

	public void setSalutationId(long salutationId) {
		this.salutationId = salutationId;
	}
	
	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
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

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "ContactPerson [salutationId=" + salutationId + ", contactId=" + contactId + ", fname=" + fname
				+ ", lname=" + lname + ", email=" + email + ", workPhone=" + workPhone + ", mobile=" + mobile + "]";
	}
}
