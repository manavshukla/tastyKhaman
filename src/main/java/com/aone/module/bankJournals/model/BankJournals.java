package com.aone.module.bankJournals.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.bankJournals.constant.BankJournalsDbColPojoConstant;

@Entity
@Table(name = "bank_journals")
public class BankJournals extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = BankJournalsDbColPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;

	@Column(name = BankJournalsDbColPojoConstant.CONTACT_ID)
	private long contactId;

	@Column(name = BankJournalsDbColPojoConstant.AMOUNT)
	private double amount;

	@Column(name = BankJournalsDbColPojoConstant.BILL_ID)
	private double billid;

	@Column(name = BankJournalsDbColPojoConstant.DESCRIPTION)
	private String description;

	@Column(name = BankJournalsDbColPojoConstant.REMARK1)
	private String remark1;

	@Column(name = BankJournalsDbColPojoConstant.DEBIT_CREDIT_FLAG)
	private String debitCreditFlag;

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBillid() {
		return billid;
	}

	public void setBillid(double billid) {
		this.billid = billid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getDebitCreditFlag() {
		return debitCreditFlag;
	}

	public void setDebitCreditFlag(String debitCreditFlag) {
		this.debitCreditFlag = debitCreditFlag;
	}

	@Override
	public String toString() {
		return "BankJournals [transactionDate=" + transactionDate
				+ ", contactId=" + contactId + ", amount=" + amount
				+ ", billid=" + billid + ", description=" + description
				+ ", remark1=" + remark1 + ", debitCreditFlag="
				+ debitCreditFlag + "]";
	}

}
