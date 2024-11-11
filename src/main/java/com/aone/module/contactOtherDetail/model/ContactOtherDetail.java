package com.aone.module.contactOtherDetail.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.contactOtherDetail.constant.ContactOtherDetailDbColPojoConstant;

@Entity
@Table(name = "contact_other_detail")
public class ContactOtherDetail extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = ContactOtherDetailDbColPojoConstant.GST_TREATMENT )
	private String gstTreatment;
	
	@Column(name = ContactOtherDetailDbColPojoConstant.GSTIN_CODE)
	private String gstinCode;
	
	@Column(name = ContactOtherDetailDbColPojoConstant.SOURCE_OF_SUPPLY)
	private String sourceOfSupply;
	
	@Column(name = ContactOtherDetailDbColPojoConstant.CURRENCY_ID)
	private long currencyId;
	
	@Column(name = ContactOtherDetailDbColPojoConstant.CONTACT_PAYMENT_TERMS_ID)
	private long contactPaymentTermsId;
	
	@Column(name = ContactOtherDetailDbColPojoConstant.CONTACT_ID)
	private long  contactId;
	
	public String getGstTreatment() {
		return gstTreatment;
	}

	public void setGstTreatment(String gstTreatment) {
		this.gstTreatment = gstTreatment;
	}

	public String getGstinCode() {
		return gstinCode;
	}

	public void setGstinCode(String gstinCode) {
		this.gstinCode = gstinCode;
	}

	public String getSourceOfSupply() {
		return sourceOfSupply;
	}

	public void setSourceOfSupply(String sourceOfSupply) {
		this.sourceOfSupply = sourceOfSupply;
	}
	
	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ContactOtherDetail [gstTreatment=" + gstTreatment + ", gstinCode=" + gstinCode + ", sourceOfSupply="
				+ sourceOfSupply + ", currencyId=" + currencyId + ", contactPaymentTermsId=" + contactPaymentTermsId
				+ ", contactId=" + contactId + "]";
	}

}
