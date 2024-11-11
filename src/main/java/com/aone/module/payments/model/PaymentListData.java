package com.aone.module.payments.model;

import java.util.List;

public class PaymentListData {
	
	private List<PaymentsMaster> crList;
	private List<PaymentsMaster> drList;
	
	
	public List<PaymentsMaster> getCrList() {
		return crList;
	}

	public void setCrList(List<PaymentsMaster> crList) {
		this.crList = crList;
	}

	public List<PaymentsMaster> getDrList() {
		return drList;
	}

	public void setDrList(List<PaymentsMaster> drList) {
		this.drList = drList;
	}

	@Override
	public String toString() {
		return "PaymentListData [crList=" + crList + ", drList=" + drList + "]";
	}

}
