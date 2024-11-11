package com.aone.module.sales.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.address.model.Address;
import com.aone.module.contact.model.Contact;
import com.aone.module.saleWorkerHelper.model.SaleWorkerHelper;
import com.aone.module.sales.constant.SalesDbColPojoConstant;
import com.aone.module.salesDetails.model.SalesDetails;
import com.aone.module.salesDriverDetails.model.SaleDriverDetails;
import com.aone.module.salesThirdParty.model.SalesThirdParty;

@Entity
@Table(name = "sales")
public class Sales extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = SalesDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = SalesDbColPojoConstant.BOOKING_DATE)
	private LocalDateTime bookingDate;
	
	@Column(name = SalesDbColPojoConstant.ORDER_DATE)
	private LocalDateTime orderDate;
	
	@Column(name = SalesDbColPojoConstant.DURATION)
	private String duration;
	
	@Column(name = SalesDbColPojoConstant.TIME)
	private String time;

	@Column(name = SalesDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = SalesDbColPojoConstant.NET_AMOUNT)
	private double netAmount;
	
	@Column(name = SalesDbColPojoConstant.DISCOUNT)
	private double discount;
	
	@Column(name = SalesDbColPojoConstant.ORDER_TYPE)
	private int orderType;
	
	@Column(name = SalesDbColPojoConstant.DESCRIPTION)
	private String description;
	
	@Column(name = SalesDbColPojoConstant.ADVANCE)
	private double advance;
	
	@Transient
	private Contact contact; 

	@Transient
	private List<SalesDetails> salesDetails;
	
	@Transient
	private Address shippingAddress;
	
	@Transient
	private List<SaleWorkerHelper> saleWorkerHelpers;
	
	@Transient
	private List<SalesThirdParty> salesThirdParties;
	
	@Transient
	private List<SaleDriverDetails> saleDriverDetails;
	
	@Transient
	private SalesInitData salesInitData;
	
	@Transient
	private String searchValue;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SalesDetails> getSalesDetails() {
		return salesDetails;
	}

	public void setSalesDetails(List<SalesDetails> salesDetails) {
		this.salesDetails = salesDetails;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<SaleWorkerHelper> getSaleWorkerHelpers() {
		return saleWorkerHelpers;
	}

	public void setSaleWorkerHelpers(List<SaleWorkerHelper> saleWorkerHelpers) {
		this.saleWorkerHelpers = saleWorkerHelpers;
	}

	public List<SalesThirdParty> getSalesThirdParties() {
		return salesThirdParties;
	}

	public void setSalesThirdParties(List<SalesThirdParty> salesThirdParties) {
		this.salesThirdParties = salesThirdParties;
	}

	public List<SaleDriverDetails> getSaleDriverDetails() {
		return saleDriverDetails;
	}

	public void setSaleDriverDetails(List<SaleDriverDetails> saleDriverDetails) {
		this.saleDriverDetails = saleDriverDetails;
	}
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public SalesInitData getSalesInitData() {
		return salesInitData;
	}

	public void setSalesInitData(SalesInitData salesInitData) {
		this.salesInitData = salesInitData;
	}

	public double getAdvance() {
		return advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "Sales [contactId=" + contactId + ", bookingDate=" + bookingDate + ", orderDate=" + orderDate
				+ ", duration=" + duration + ", time=" + time + ", grossAmount=" + grossAmount + ", netAmount="
				+ netAmount + ", discount=" + discount + ", orderType=" + orderType + ", description=" + description
				+ ", advance=" + advance + ", contact=" + contact + ", salesDetails=" + salesDetails
				+ ", shippingAddress=" + shippingAddress + ", saleWorkerHelpers=" + saleWorkerHelpers
				+ ", salesThirdParties=" + salesThirdParties + ", saleDriverDetails=" + saleDriverDetails
				+ ", salesInitData=" + salesInitData + ", searchValue=" + searchValue + "]";
	}
	

}
