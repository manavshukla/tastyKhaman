package com.aone.module.contactvehicle.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.contactvehicle.constant.ContactVehicleDbColmPojoConstant;


@Entity
@Table(name = "contactVehicle")
public class ContactVehicle extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038293081954544062L;

	@Column(name=ContactVehicleDbColmPojoConstant.AMC_REGISTRATION_DATE)
	private LocalDateTime AMCRegistrationDate;
	
	@Column(name=ContactVehicleDbColmPojoConstant.BRAND_NAME)
	private String brandName;

	@Column(name=ContactVehicleDbColmPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name=ContactVehicleDbColmPojoConstant.MODEL_NO)
	private String modelNo;
	
	@Column(name=ContactVehicleDbColmPojoConstant.REGISTRATION_NO)
	private String registrationNo;
	
	@Column(name=ContactVehicleDbColmPojoConstant.YEAR_OF_MANUFACTURE)
	private String yearOfManufacture;

	public LocalDateTime getAMCRegistrationDate() {
		return AMCRegistrationDate;
	}

	public void setAMCRegistrationDate(LocalDateTime aMCRegistrationDate) {
		AMCRegistrationDate = aMCRegistrationDate;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(String yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	@Override
	public String toString() {
		return "ContactVehicle [AMCRegistrationDate=" + AMCRegistrationDate + ", brandName=" + brandName
				+ ", contactId=" + contactId + ", modelNo=" + modelNo + ", registrationNo=" + registrationNo
				+ ", yearOfManufacture=" + yearOfManufacture + "]";
	}
}
