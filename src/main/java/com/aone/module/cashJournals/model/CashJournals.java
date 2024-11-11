

  package com.aone.module.cashJournals.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.cashJournals.constant.CashJournalsDbColPojoConstant;

@Entity
@Table(name = "cash_journals")
public class CashJournals extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = CashJournalsDbColPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;

	@Column(name = CashJournalsDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = CashJournalsDbColPojoConstant.AMOUNT)
	private double amount;
	
	@Column(name = CashJournalsDbColPojoConstant.BILL_ID)
	private long billId;
	
	@Column(name = CashJournalsDbColPojoConstant.DESCRIPTION)
	private String description;
	
	@Column(name = CashJournalsDbColPojoConstant.REMARK1)
	private String remark1;
	
	@Column(name = CashJournalsDbColPojoConstant.DEBIT_CREDIT_FLAG)
	private int debitCreditFlag;

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

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
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

	public int getDebitCreditFlag() {
		return debitCreditFlag;
	}

	public void setDebitCreditFlag(int debitCreditFlag) {
		this.debitCreditFlag = debitCreditFlag;
	}

	@Override
	public String toString() {
		return "CashJournals [transactionDate=" + transactionDate
				+ ", contactId=" + contactId + ", amount=" + amount
				+ ", billId=" + billId + ", description=" + description
				+ ", remark1=" + remark1 + ", debitCreditFlag="
				+ debitCreditFlag + "]";
	}
	
}