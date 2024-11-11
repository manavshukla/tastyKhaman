package com.aone.module.contact.model;

import java.util.List;

public class ContactTypeDataList {
	private List<Contact> customerContactList;
	private List<Contact> driverContactList;
	private List<Contact> retailerContactList;
	private List<Contact> thirdPartyContactList;
	private List<Contact> vendorDealerContactList;
	private List<Contact> workerHelperContactList;
	private List<Contact> otherContactList;
	public List<Contact> getCustomerContactList() {
		return customerContactList;
	}
	public void setCustomerContactList(List<Contact> customerContactList) {
		this.customerContactList = customerContactList;
	}
	public List<Contact> getDriverContactList() {
		return driverContactList;
	}
	public void setDriverContactList(List<Contact> driverContactList) {
		this.driverContactList = driverContactList;
	}
	public List<Contact> getRetailerContactList() {
		return retailerContactList;
	}
	public void setRetailerContactList(List<Contact> retailerContactList) {
		this.retailerContactList = retailerContactList;
	}
	public List<Contact> getThirdPartyContactList() {
		return thirdPartyContactList;
	}
	public void setThirdPartyContactList(List<Contact> thirdPartyContactList) {
		this.thirdPartyContactList = thirdPartyContactList;
	}
	public List<Contact> getVendorDealerContactList() {
		return vendorDealerContactList;
	}
	public void setVendorDealerContactList(List<Contact> vendorDealerContactList) {
		this.vendorDealerContactList = vendorDealerContactList;
	}
	public List<Contact> getWorkerHelperContactList() {
		return workerHelperContactList;
	}
	public void setWorkerHelperContactList(List<Contact> workerHelperContactList) {
		this.workerHelperContactList = workerHelperContactList;
	}
	public List<Contact> getOtherContactList() {
		return otherContactList;
	}
	public void setOtherContactList(List<Contact> otherContactList) {
		this.otherContactList = otherContactList;
	}
	
	@Override
	public String toString() {
		return "ContactTypeDataList [customerContactList=" + customerContactList + ", driverContactList="
				+ driverContactList + ", retailerContactList=" + retailerContactList + ", thirdPartyContactList="
				+ thirdPartyContactList + ", vendorDealerContactList=" + vendorDealerContactList
				+ ", workerHelperContactList=" + workerHelperContactList + ", otherContactList=" + otherContactList
				+ "]";
	}
}
