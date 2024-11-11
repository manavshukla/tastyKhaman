package com.aone.module.salesThirdParty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.salesThirdParty.constant.SalesThirdPartyDbColPojoConstant;

@Entity
@Table(name = "sales_third_party")
public class SalesThirdParty extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = SalesThirdPartyDbColPojoConstant.SALES_ID)
	private long salesId;
	
	@Column(name = SalesThirdPartyDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = SalesThirdPartyDbColPojoConstant.ADVANCE)
	private double advance;
	
	@Column(name = SalesThirdPartyDbColPojoConstant.NO_OF_PERSON)
	private long noOfPerson;
	
	@Column(name = SalesThirdPartyDbColPojoConstant.TOTAL_AMOUNT)
	private double totalAmount;
	
	@Column(name = SalesThirdPartyDbColPojoConstant.DESCRIPTION)
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

	public long getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(long noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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
		return "SalesThirdParty [salesId=" + salesId + ", contactId=" + contactId + ", advance=" + advance + ", noOfPerson=" + noOfPerson + ", totalAmount=" + totalAmount + ", description=" + description + "]";
	}

}
