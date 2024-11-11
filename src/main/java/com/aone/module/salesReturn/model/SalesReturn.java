package com.aone.module.salesReturn.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.salesReturn.constant.SalesReturnDbColPojoConstant;

@Entity
@Table(name = "sales_return")
public class SalesReturn extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = SalesReturnDbColPojoConstant.SALES_ID)
	private long salesId;
	
	@Column(name = SalesReturnDbColPojoConstant.BILL_NO)
	private String billNo;
	
	@Column(name = SalesReturnDbColPojoConstant.BILL_PREFIX)
	private String billPrefix;
	
	@Column(name = SalesReturnDbColPojoConstant.BILL_SUFFIX)
	private String billSuffix;
	
	@Column(name = SalesReturnDbColPojoConstant.BILL_DATE)
	private LocalDateTime billDate;
	
	@Column(name = SalesReturnDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = SalesReturnDbColPojoConstant.LR_NO)
	private String lrNo;
	
	@Column(name = SalesReturnDbColPojoConstant.TRANSPORT_DETAIL)
	private String transportDetail;
	
	@Column(name = SalesReturnDbColPojoConstant.REVERSE_CHARGE)
	private String reverseCharge;
	
	@Column(name = SalesReturnDbColPojoConstant.PF_CHARGE)
	private double  pfCharge;

	@Column(name = SalesReturnDbColPojoConstant.PF_GST_RATE)
	private double pfGstRate;
	
	@Column(name = SalesReturnDbColPojoConstant.PF_TOTAL_AMOUNT)
	private double pfTotalAmount;
	
	@Column(name = SalesReturnDbColPojoConstant.NET_AMOUNT)
	private double netAmount;
	
	@Column(name = SalesReturnDbColPojoConstant.CGST_RATE)
	private double cgstRate;
	
	@Column(name = SalesReturnDbColPojoConstant.CGST_AMOUNT)
	private double cgstAmount;
	
	@Column(name = SalesReturnDbColPojoConstant.SGST_RATE)
	private double sgstRate;
	
	@Column(name = SalesReturnDbColPojoConstant.SGST_AMOUNT)
	private double sgstAmount;
	
	@Column(name = SalesReturnDbColPojoConstant.IGST_RATE)
	private double igstRate;
	
	@Column(name = SalesReturnDbColPojoConstant.IGST_AMOUNT)
	private double igstAmount;
	
	@Column(name = SalesReturnDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = SalesReturnDbColPojoConstant.ROUND_AMOUNT_OPTION)
	private double roundAmountOption;

	@Column(name = SalesReturnDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getSalesId() {
		return salesId;
	}

	public void setSalesId(long salesId) {
		this.salesId = salesId;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBillPrefix() {
		return billPrefix;
	}

	public void setBillPrefix(String billPrefix) {
		this.billPrefix = billPrefix;
	}

	public String getBillSuffix() {
		return billSuffix;
	}

	public void setBillSuffix(String billSuffix) {
		this.billSuffix = billSuffix;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
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
		return "SalesReturn [salesId=" + salesId + ", billNo=" + billNo + ", billPrefix=" + billPrefix + ", billSuffix="
				+ billSuffix + ", billDate=" + billDate + ", contactId=" + contactId + ", lrNo=" + lrNo
				+ ", transportDetail=" + transportDetail + ", reverseCharge=" + reverseCharge + ", pfCharge=" + pfCharge
				+ ", pfGstRate=" + pfGstRate + ", pfTotalAmount=" + pfTotalAmount + ", netAmount=" + netAmount
				+ ", cgstRate=" + cgstRate + ", cgstAmount=" + cgstAmount + ", sgstRate=" + sgstRate + ", sgstAmount="
				+ sgstAmount + ", igstRate=" + igstRate + ", igstAmount=" + igstAmount + ", grossAmount=" + grossAmount
				+ ", roundAmountOption=" + roundAmountOption + ", description=" + description + "]";
	}

}
