package com.aone.module.contactCategory.constant;

public enum ContactCategoryConstant {

	CUSTOMER("Customer"),
	DRIVER("Driver"),
	RETAILER("Retailer"),
	THIRD_PARTY("Third Party"),
	VENDOR_DEALER("Vendor/Dealer"),
	WORKER_HELPER("Worker/Helper"),
	OTHER("Other")
	;
	
	private String value;

	private ContactCategoryConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
