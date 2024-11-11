package com.aone.module.purchase.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.contact.model.Contact;
import com.aone.module.purchase.constant.PurchaseDbColPojoConstant;
import com.aone.module.purchaseDetails.model.PurchaseDetails;
import com.aone.module.sales.model.SalesInitData;

@Entity
@Table(name = "purchase")
public class Purchase extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = PurchaseDbColPojoConstant.VENDOR_BILL_NO)
	private String vendorBillNo;
	
	@Column(name = PurchaseDbColPojoConstant.PURCHASE_DATE)
	private LocalDateTime purchaseDate;
	
	@Column(name = PurchaseDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = PurchaseDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = PurchaseDbColPojoConstant.DISCOUNT)
	private double discount;
	
	@Column(name = PurchaseDbColPojoConstant.NET_AMOUNT)
	private double netAmount;

	@Column(name = PurchaseDbColPojoConstant.DESCRIPTION)
	private String description;
	
	@Transient
	private List<PurchaseDetails> purchaseDetails;
	
	@Transient
	private Contact contact;
	
	@Transient
	private String searchValue;
	
	@Transient
	private SalesInitData salesInitData;

	public String getVendorBillNo() {
		return vendorBillNo;
	}

	public void setVendorBillNo(String vendorBillNo) {
		this.vendorBillNo = vendorBillNo;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<PurchaseDetails> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(List<PurchaseDetails> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	
	public SalesInitData getSalesInitData() {
		return salesInitData;
	}

	public void setSalesInitData(SalesInitData salesInitData) {
		this.salesInitData = salesInitData;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "Purchase [vendorBillNo=" + vendorBillNo + ", purchaseDate=" + purchaseDate + ", contactId=" + contactId
				+ ", grossAmount=" + grossAmount + ", discount=" + discount + ", netAmount=" + netAmount
				+ ", description=" + description + ", purchaseDetails=" + purchaseDetails + ", contact=" + contact
				+ ", searchValue=" + searchValue + ", salesInitData=" + salesInitData + "]";
	}
}
