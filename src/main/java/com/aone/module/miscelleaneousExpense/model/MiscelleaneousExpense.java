package com.aone.module.miscelleaneousExpense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.miscelleaneousExpense.constant.MiscelleaneousExpenseDbColPojoConstant;

@Entity
@Table(name = "miscelleaneous_expense")
public class MiscelleaneousExpense extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = MiscelleaneousExpenseDbColPojoConstant.TYPE_ID)
	private long typeId;
	
	@Column(name = MiscelleaneousExpenseDbColPojoConstant.AMOUNT)
	private double amount;
	
	@Column(name = MiscelleaneousExpenseDbColPojoConstant.DESCRIPTION)
	private String description;
	
	@Column(name = MiscelleaneousExpenseDbColPojoConstant.PAYMENT_TYPE)
	private String paymentType;
	
	@Column(name = MiscelleaneousExpenseDbColPojoConstant.CHEUQE_NO)
	private String cheuqeNo;
	
	@Column(name = MiscelleaneousExpenseDbColPojoConstant.BANK_NAME)
	private String bankName;
	
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCheuqeNo() {
		return cheuqeNo;
	}
	public void setCheuqeNo(String cheuqeNo) {
		this.cheuqeNo = cheuqeNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "MiscelleaneousExpense [typeId=" + typeId + ", amount=" + amount
				+ ", description=" + description + ", paymentType="
				+ paymentType + ", cheuqeNo=" + cheuqeNo + ", bankName="
				+ bankName + "]";
	}
	
}
