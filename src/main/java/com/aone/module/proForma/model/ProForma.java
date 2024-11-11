package com.aone.module.proForma.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.proForma.constant.ProFormaDbColPojoConstant;

@Entity
@Table(name = "pro_forma")
public class ProForma extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = ProFormaDbColPojoConstant.PER_FORMA_NO)
	private long perFormaNo;
	
	@Column(name = ProFormaDbColPojoConstant.BILL_DATE)
	private LocalDateTime billDate;
	
	@Column(name = ProFormaDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = ProFormaDbColPojoConstant.PAYMENT_TERMS)
	private String paymentTerms;
	
	@Column(name = ProFormaDbColPojoConstant.REVERSE_CHARGE)
	private String reverseCharge;
	
	@Column(name = ProFormaDbColPojoConstant.PF_CHARGE)
	private double  pfCharge;

	@Column(name = ProFormaDbColPojoConstant.PF_GST_RATE)
	private double pfGstRate;
	
	@Column(name = ProFormaDbColPojoConstant.PF_TOTAL_AMOUNT)
	private double pfTotalAmount;
	
	@Column(name = ProFormaDbColPojoConstant.NET_AMOUNT)
	private double netAmount;
	
	@Column(name = ProFormaDbColPojoConstant.CGST_RATE)
	private double cgstRate;
	
	@Column(name = ProFormaDbColPojoConstant.CGST_AMOUNT)
	private double cgstAmount;
	
	@Column(name = ProFormaDbColPojoConstant.SGST_RATE)
	private double sgstRate;
	
	@Column(name = ProFormaDbColPojoConstant.SGST_AMOUNT)
	private double sgstAmount;
	
	@Column(name = ProFormaDbColPojoConstant.IGST_RATE)
	private double igstRate;
	
	@Column(name = ProFormaDbColPojoConstant.IGST_AMOUNT)
	private double igstAmount;
	
	@Column(name = ProFormaDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = ProFormaDbColPojoConstant.ROUND_AMOUNT_OPTION)
	private double roundAmountOption;

	@Column(name = ProFormaDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getPerFormaNo() {
		return perFormaNo;
	}

	public void setPerFormaNo(long perFormaNo) {
		this.perFormaNo = perFormaNo;
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

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
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

	@Override
	public String toString() {
		return "ProForma [perFormaNo=" + perFormaNo + ", billDate=" + billDate + ", contactId=" + contactId
				+ ", paymentTerms=" + paymentTerms + ", reverseCharge=" + reverseCharge + ", pfCharge=" + pfCharge
				+ ", pfGstRate=" + pfGstRate + ", pfTotalAmount=" + pfTotalAmount + ", netAmount=" + netAmount
				+ ", cgstRate=" + cgstRate + ", cgstAmount=" + cgstAmount + ", sgstRate=" + sgstRate + ", sgstAmount="
				+ sgstAmount + ", igstRate=" + igstRate + ", igstAmount=" + igstAmount + ", grossAmount=" + grossAmount
				+ ", roundAmountOption=" + roundAmountOption + ", description=" + description + "]";
	}

}
