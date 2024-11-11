package com.aone.module.purchaseOrder.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.purchaseOrder.constant.PurchaseOrderDbColPojoConstant;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = PurchaseOrderDbColPojoConstant.ORDER_NO)
	private long orderNo;
	
	@Column(name = PurchaseOrderDbColPojoConstant.ORDER_DATE)
	private LocalDateTime orderDate;
	
	@Column(name = PurchaseOrderDbColPojoConstant.EXPECTED_DELIVERY_DATE)
	private LocalDateTime expectedDeliveryDate;
	
	@Column(name = PurchaseOrderDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = PurchaseOrderDbColPojoConstant.REVERSE_CHARGE)
	private String reverseCharge;
	
	@Column(name = PurchaseOrderDbColPojoConstant.PF_CHARGE)
	private double  pfCharge;

	@Column(name = PurchaseOrderDbColPojoConstant.PF_GST_RATE)
	private double pfGstRate;
	
	@Column(name = PurchaseOrderDbColPojoConstant.PF_TOTAL_AMOUNT)
	private double pfTotalAmount;
	
	@Column(name = PurchaseOrderDbColPojoConstant.NET_AMOUNT)
	private double netAmount;
	
	@Column(name = PurchaseOrderDbColPojoConstant.CGST_RATE)
	private double cgstRate;
	
	@Column(name = PurchaseOrderDbColPojoConstant.CGST_AMOUNT)
	private double cgstAmount;
	
	@Column(name = PurchaseOrderDbColPojoConstant.SGST_RATE)
	private double sgstRate;
	
	@Column(name = PurchaseOrderDbColPojoConstant.SGST_AMOUNT)
	private double sgstAmount;
	
	@Column(name = PurchaseOrderDbColPojoConstant.IGST_RATE)
	private double igstRate;
	
	@Column(name = PurchaseOrderDbColPojoConstant.IGST_AMOUNT)
	private double igstAmount;
	
	@Column(name = PurchaseOrderDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = PurchaseOrderDbColPojoConstant.ROUND_AMOUNT_OPTION)
	private double roundAmountOption;

	@Column(name = PurchaseOrderDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDateTime expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getReverseCharge() {
		return reverseCharge;
	}

	public void setReverseCharge(String reverseCharge) {
		this.reverseCharge = reverseCharge;
	}

	public double getPfCharge() {
		return pfCharge;
	}

	public void setPfCharge(double pfCharge) {
		this.pfCharge = pfCharge;
	}

	public double getPfGstRate() {
		return pfGstRate;
	}

	public void setPfGstRate(double pfGstRate) {
		this.pfGstRate = pfGstRate;
	}

	public double getPfTotalAmount() {
		return pfTotalAmount;
	}

	public void setPfTotalAmount(double pfTotalAmount) {
		this.pfTotalAmount = pfTotalAmount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getCgstRate() {
		return cgstRate;
	}

	public void setCgstRate(double cgstRate) {
		this.cgstRate = cgstRate;
	}

	public double getCgstAmount() {
		return cgstAmount;
	}

	public void setCgstAmount(double cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	public double getSgstRate() {
		return sgstRate;
	}

	public void setSgstRate(double sgstRate) {
		this.sgstRate = sgstRate;
	}

	public double getSgstAmount() {
		return sgstAmount;
	}

	public void setSgstAmount(double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	public double getIgstRate() {
		return igstRate;
	}

	public void setIgstRate(double igstRate) {
		this.igstRate = igstRate;
	}

	public double getIgstAmount() {
		return igstAmount;
	}

	public void setIgstAmount(double igstAmount) {
		this.igstAmount = igstAmount;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getRoundAmountOption() {
		return roundAmountOption;
	}

	public void setRoundAmountOption(double roundAmountOption) {
		this.roundAmountOption = roundAmountOption;
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
		return "PurchaseOrder [orderNo=" + orderNo + ", orderDate=" + orderDate + ", expectedDeliveryDate="
				+ expectedDeliveryDate + ", contactId=" + contactId + ", reverseCharge=" + reverseCharge + ", pfCharge="
				+ pfCharge + ", pfGstRate=" + pfGstRate + ", pfTotalAmount=" + pfTotalAmount + ", netAmount="
				+ netAmount + ", cgstRate=" + cgstRate + ", cgstAmount=" + cgstAmount + ", sgstRate=" + sgstRate
				+ ", sgstAmount=" + sgstAmount + ", igstRate=" + igstRate + ", igstAmount=" + igstAmount
				+ ", grossAmount=" + grossAmount + ", roundAmountOption=" + roundAmountOption + ", description="
				+ description + "]";
	}

}
