package com.aone.module.purchaseReturn.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.purchaseReturn.constant.PurchaseReturnDbColPojoConstant;

@Entity
@Table(name = "purchase_return")
public class PurchaseReturn extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = PurchaseReturnDbColPojoConstant.PURCHASE_ID)
	private long purchaseId;
	
	@Column(name = PurchaseReturnDbColPojoConstant.PURCHASE_RETURN_DATE)
	private LocalDateTime purchaseReturnDate;
	
	@Column(name = PurchaseReturnDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = PurchaseReturnDbColPojoConstant.LR_NO)
	private String lrNo;
	
	@Column(name = PurchaseReturnDbColPojoConstant.TRANSPORT_DETAIL)
	private String transportDetail;
	
	@Column(name = PurchaseReturnDbColPojoConstant.REVERSE_CHARGE)
	private String reverseCharge;
	
	@Column(name = PurchaseReturnDbColPojoConstant.PF_CHARGE)
	private double  pfCharge;

	@Column(name = PurchaseReturnDbColPojoConstant.PF_GST_RATE)
	private double pfGstRate;
	
	@Column(name = PurchaseReturnDbColPojoConstant.PF_TOTAL_AMOUNT)
	private double pfTotalAmount;
	
	@Column(name = PurchaseReturnDbColPojoConstant.NET_AMOUNT)
	private double netAmount;
	
	@Column(name = PurchaseReturnDbColPojoConstant.CGST_RATE)
	private double cgstRate;
	
	@Column(name = PurchaseReturnDbColPojoConstant.CGST_AMOUNT)
	private double cgstAmount;
	
	@Column(name = PurchaseReturnDbColPojoConstant.SGST_RATE)
	private double sgstRate;
	
	@Column(name = PurchaseReturnDbColPojoConstant.SGST_AMOUNT)
	private double sgstAmount;
	
	@Column(name = PurchaseReturnDbColPojoConstant.IGST_RATE)
	private double igstRate;
	
	@Column(name = PurchaseReturnDbColPojoConstant.IGST_AMOUNT)
	private double igstAmount;
	
	@Column(name = PurchaseReturnDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = PurchaseReturnDbColPojoConstant.ROUND_AMOUNT_OPTION)
	private double roundAmountOption;

	@Column(name = PurchaseReturnDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public LocalDateTime getPurchaseReturnDate() {
		return purchaseReturnDate;
	}

	public void setPurchaseReturnDate(LocalDateTime purchaseReturnDate) {
		this.purchaseReturnDate = purchaseReturnDate;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}

	public String getTransportDetail() {
		return transportDetail;
	}

	public void setTransportDetail(String transportDetail) {
		this.transportDetail = transportDetail;
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
		return "PurchaseReturn [purchaseId=" + purchaseId + ", purchaseReturnDate=" + purchaseReturnDate
				+ ", contactId=" + contactId + ", lrNo=" + lrNo + ", transportDetail=" + transportDetail
				+ ", reverseCharge=" + reverseCharge + ", pfCharge=" + pfCharge + ", pfGstRate=" + pfGstRate
				+ ", pfTotalAmount=" + pfTotalAmount + ", netAmount=" + netAmount + ", cgstRate=" + cgstRate
				+ ", cgstAmount=" + cgstAmount + ", sgstRate=" + sgstRate + ", sgstAmount=" + sgstAmount + ", igstRate="
				+ igstRate + ", igstAmount=" + igstAmount + ", grossAmount=" + grossAmount + ", roundAmountOption="
				+ roundAmountOption + ", description=" + description + "]";
	}

}
