package com.aone.module.payments.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.payments.constant.PaymentsDbColmPojoConstant;


@Entity
@Table(name = "payment_master")
public class PaymentsMaster extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038293081954574066L;

	@Column(name=PaymentsDbColmPojoConstant.BILL_ID)
	private long billId;
	
	@Column(name=PaymentsDbColmPojoConstant.BILL_NO)
	private String billNo;
	
	@Column(name=PaymentsDbColmPojoConstant.CONTACT_ID)
	private long contactId;

	@Column(name=PaymentsDbColmPojoConstant.PAYMENT_MODE)
	private String paymentMode;
	
	@Column(name=PaymentsDbColmPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;
	
	@Column(name=PaymentsDbColmPojoConstant.AMOUNT)
	private double amount;
	
	@Column(name=PaymentsDbColmPojoConstant.CREDIT_DEBIT_FLAG)
	private int creditDebitFlag;
	
	@Column(name=PaymentsDbColmPojoConstant.ENTRY_TYPE)
	private String entryType;
	
	@Column(name=PaymentsDbColmPojoConstant.SYSTEM_GENERATED)
	private boolean systemGenerated;
	
	@Column(name=PaymentsDbColmPojoConstant.DESCRIPTION)
	private String description;
	
	public long getBillId() {
		return billId;
	}


	public void setBillId(long billId) {
		this.billId = billId;
	}


	public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	public long getContactId() {
		return contactId;
	}


	public void setContactId(long contactId) {
		this.contactId = contactId;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getCreditDebitFlag() {
		return creditDebitFlag;
	}


	public void setCreditDebitFlag(int creditDebitFlag) {
		this.creditDebitFlag = creditDebitFlag;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getEntryType() {
		return entryType;
	}


	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}
	
	
	public boolean isSystemGenerated() {
		return systemGenerated;
	}


	public void setSystemGenerated(boolean systemGenerated) {
		this.systemGenerated = systemGenerated;
	}


	@Override
	public String toString() {
		return "PaymentsMaster [billId=" + billId + ", billNo=" + billNo + ", contactId=" + contactId + ", paymentMode=" + paymentMode + ", transactionDate=" + transactionDate + ", amount=" + amount + ", creditDebitFlag="
				+ creditDebitFlag + ", entryType=" + entryType + ", description=" + description + "]";
	}

}
