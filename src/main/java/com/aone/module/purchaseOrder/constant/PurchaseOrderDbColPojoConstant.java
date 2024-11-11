package com.aone.module.purchaseOrder.constant;

public class PurchaseOrderDbColPojoConstant {
	
	public static final String ORDER_NO="order_no";
	public static final String ORDER_DATE="order_date";
	public static final String EXPECTED_DELIVERY_DATE="expected_delivery_date";
	public static final String CONTACT_ID="contact_id";
	public static final String REVERSE_CHARGE="reverse_charge";
	public static final String PF_CHARGE="pf_charge";
	public static final String PF_GST_RATE="pf_gst_rate";
	public static final String PF_TOTAL_AMOUNT="pf_total_amount";
	public static final String NET_AMOUNT="net_amount";
	public static final String CGST_RATE="cgst_rate";
	public static final String CGST_AMOUNT="cgst_amount";
	public static final String SGST_RATE="sgst_rate";
	public static final String SGST_AMOUNT="sgst_amount";
	public static final String IGST_RATE="igst_rate";
	public static final String IGST_AMOUNT="igst_amount";
	public static final String GROSS_AMOUNT="gross_amount";
	public static final String ROUND_AMOUNT_OPTION="round_amount_option";
	public static final String DESCRIPTION ="description";
	
	private PurchaseOrderDbColPojoConstant() {
		throw new IllegalStateException("Constant class");
	}
}
