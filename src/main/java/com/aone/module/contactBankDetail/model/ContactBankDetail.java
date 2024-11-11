package com.aone.module.contactBankDetail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.contactBankDetail.constant.ContactBankDetailDbColPojoConstant;

@Entity
@Table(name = "contact_bank_detail")
public class ContactBankDetail extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = ContactBankDetailDbColPojoConstant.BANK_NAME)
	private String bankName;

	@Column(name = ContactBankDetailDbColPojoConstant.ACCOUNT_NUMBER)
	private String accountNumber;

	@Column(name = ContactBankDetailDbColPojoConstant.IFS_CODE)
	private String ifsCode;

	@Column(name = ContactBankDetailDbColPojoConstant.BRANCH_NAME)
	private String branchName;

	@Column(name = ContactBankDetailDbColPojoConstant.CONTACT_ID)
	private long contactId;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "ContactBankDetail [bankName=" + bankName + ", accountNumber=" + accountNumber + ", ifsCode=" + ifsCode
				+ ", branchName=" + branchName + ", contactId=" + contactId + "]";
	}

}
