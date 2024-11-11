package com.aone.module.salesDriverDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.salesDriverDetails.constant.SaleDriverDetailsDbColPojoConstant;

@Entity
@Table(name = "sale_driver_details")
public class SaleDriverDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = SaleDriverDetailsDbColPojoConstant.SALES_ID)
	private long salesId;
	
	@Column(name = SaleDriverDetailsDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = SaleDriverDetailsDbColPojoConstant.VEHICLE_NO)
	private String vehicleNo;
	
	@Column(name = SaleDriverDetailsDbColPojoConstant.RATE)
	private double rate;
	
	@Column(name = SaleDriverDetailsDbColPojoConstant.ADVANCE)
	private double advance;
	
	@Column(name = SaleDriverDetailsDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getSalesId() {
		return salesId;
	}

	public void setSalesId(long salesId) {
		this.salesId = salesId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getAdvance() {
		return advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	@Override
	public String toString() {
		return "SaleDriverDetails [salesId=" + salesId + ", contactId=" + contactId + ", vehicleNo=" + vehicleNo + ", rate=" + rate + ", advance=" + advance + ", description=" + description + "]";
	}

}
