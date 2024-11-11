package com.aone.module.saleWorkerHelper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.saleWorkerHelper.constant.SaleWorkerHelperDbColPojoConstant;

@Entity
@Table(name = "sale_worker_helper")
public class SaleWorkerHelper extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = SaleWorkerHelperDbColPojoConstant.SALES_ID)
	private long salesId;
	
	@Column(name = SaleWorkerHelperDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = SaleWorkerHelperDbColPojoConstant.ROLE)
	private String role;
	
	@Column(name = SaleWorkerHelperDbColPojoConstant.RATE)
	private double rate;
	
	@Column(name = SaleWorkerHelperDbColPojoConstant.ADVANCE)
	private double advance;
	
	@Column(name = SaleWorkerHelperDbColPojoConstant.DESCRIPTION)
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	@Override
	public String toString() {
		return "SaleOrderWorkerHelper [salesId=" + salesId + ", contactId=" + contactId + ", role=" + role + ", rate=" + rate + ", advance=" + advance + ", description=" + description + "]";
	}

}
