package com.aone.module.quotation.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.quotation.constant.QuotationDbColPojoConstant;

@Entity
@Table(name = "quotation")
public class Quotation extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = QuotationDbColPojoConstant.QUOTATION_NO)
	private long quotationNo;
	
	@Column(name = QuotationDbColPojoConstant.QUOTATION_DATE)
	private LocalDateTime quotationDate;
	
	@Column(name = QuotationDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = QuotationDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(long quotationNo) {
		this.quotationNo = quotationNo;
	}

	public LocalDateTime getQuotationDate() {
		return quotationDate;
	}

	public void setQuotationDate(LocalDateTime quotationDate) {
		this.quotationDate = quotationDate;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Quotation [quotationNo=" + quotationNo + ", quotationDate=" + quotationDate + ", contactId=" + contactId
				+ ", description=" + description + "]";
	}

}
