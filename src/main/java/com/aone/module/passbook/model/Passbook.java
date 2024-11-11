package com.aone.module.passbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.passbook.constant.PassbookDbColPojoConstant;

@Entity
@Table(name = "passbook_master")
public class Passbook extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = PassbookDbColPojoConstant.CONTACT_ID)
	private long contactId;
	
	@Column(name = PassbookDbColPojoConstant.PURCHASE_BILL_ID)
	private long purchaseBillId;
	
	@Column(name = PassbookDbColPojoConstant.SALES_BILL_ID)
	private long salesBillId;
	
	@Column(name = PassbookDbColPojoConstant.PURCHASE_RETURN_ID)
	private long purchaseReturnId;
	
	@Column(name = PassbookDbColPojoConstant.SALES_RETURN_ID)
	private long salesReturnId;
	
	@Column(name = PassbookDbColPojoConstant.SOURCE)
	private String source;
	
	@Column(name = PassbookDbColPojoConstant.PARTICULARS)
	private String particulars;
	
	@Column(name = PassbookDbColPojoConstant.BANK_NAME)
	private String bankName;
	
	@Column(name = PassbookDbColPojoConstant.ACCOUNT_NO)
	private String accountNo;
	
	@Column(name = PassbookDbColPojoConstant.IFS_CODE)
	private String ifsCode;
	
	@Column(name = PassbookDbColPojoConstant.BRANCH_NAME)
	private String branchName;
	
	@Column(name = PassbookDbColPojoConstant.AMOUNT)
	private double amount;
	
	@Column(name = PassbookDbColPojoConstant.WITHDRAW_DEPOSITE_FLAG)
	private int withdrawDepositeFlag;
	
	@Column(name = PassbookDbColPojoConstant.DESCRIPTION)
	private String description;
	
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public long getPurchaseBillId() {
		return purchaseBillId;
	}
	public void setPurchaseBillId(long purchaseBillId) {
		this.purchaseBillId = purchaseBillId;
	}
	public long getSalesBillId() {
		return salesBillId;
	}
	public void setSalesBillId(long salesBillId) {
		this.salesBillId = salesBillId;
	}
	public long getPurchaseReturnId() {
		return purchaseReturnId;
	}
	public void setPurchaseReturnId(long purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}
	public long getSalesReturnId() {
		return salesReturnId;
	}
	public void setSalesReturnId(long salesReturnId) {
		this.salesReturnId = salesReturnId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getIfsCode() {
		return ifsCode;
	}
	public void setIfsCode(String ifsCode) {
		this.ifsCode = ifsCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getWithdrawDepositeFlag() {
		return withdrawDepositeFlag;
	}
	public void setWithdrawDepositeFlag(int withdrawDepositeFlag) {
		this.withdrawDepositeFlag = withdrawDepositeFlag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Passbook [contactId=" + contactId + ", purchaseBillId=" + purchaseBillId + ", salesBillId=" + salesBillId + ", purchaseReturnId=" + purchaseReturnId + ", salesReturnId=" + salesReturnId + ", source=" + source
				+ ", particulars=" + particulars + ", bankName=" + bankName + ", accountNo=" + accountNo + ", ifsCode=" + ifsCode + ", branchName=" + branchName + ", amount=" + amount + ", withdrawDepositeFlag="
				+ withdrawDepositeFlag + ", description=" + description + "]";
	}
	
}
