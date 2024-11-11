package com.aone.module.purchaseOrderDetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.purchaseOrderDetails.constant.PurchaseOrderDetailsDbColPojoConstant;

@Entity
@Table(name = "purchase_order_details")
public class PurchaseOrderDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.ORDER_ID)
	private long orderId;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.ITEM_ID)
	private long itemId;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.ITEM_NAME)
	private String itemName;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.SIZE)
	private String size;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.UOM_ID)
	private long uomId;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.HSN_CODE)
	private String hsnCode;

	@Column(name = PurchaseOrderDetailsDbColPojoConstant.QUANTITY)
	private double quantity;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.PRICE)
	private double price;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.DISCOUNT_PERCENTAGE)
	private double discountPercentage;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.DISCOUNT_AMOUNT)
	private double discountAmount;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.CGST_RATE)
	private double cgstRate;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.CGST_AMOUNT)
	private double cgstAmount;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.SGST_RATE)
	private double sgstRate;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.SGST_AMOUNT)
	private double sgstAmount;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.IGST_RATE)
	private double igstRate;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.IGST_AMOUNT)
	private double igstAmount;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = PurchaseOrderDetailsDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getUomId() {
		return uomId;
	}

	public void setUomId(long uomId) {
		this.uomId = uomId;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getCgstRate() {
		return cgstRate;
	}

	public void setCgstRate(double cgstRate) {
		this.cgstRate = cgstRate;
	}

	public double getCgstAmount() {
		return cgstAmount;
	}

	public void setCgstAmount(double cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	public double getSgstRate() {
		return sgstRate;
	}

	public void setSgstRate(double sgstRate) {
		this.sgstRate = sgstRate;
	}

	public double getSgstAmount() {
		return sgstAmount;
	}

	public void setSgstAmount(double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	public double getIgstRate() {
		return igstRate;
	}

	public void setIgstRate(double igstRate) {
		this.igstRate = igstRate;
	}

	public double getIgstAmount() {
		return igstAmount;
	}

	public void setIgstAmount(double igstAmount) {
		this.igstAmount = igstAmount;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PurchaseOrderDetails [orderId=" + orderId
				+ ", transactionDate=" + transactionDate + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", size=" + size + ", uomId="
				+ uomId + ", hsnCode=" + hsnCode + ", quantity=" + quantity
				+ ", price=" + price + ", discountPercentage="
				+ discountPercentage + ", discountAmount=" + discountAmount
				+ ", cgstRate=" + cgstRate + ", cgstAmount=" + cgstAmount
				+ ", sgstRate=" + sgstRate + ", sgstAmount=" + sgstAmount
				+ ", igstRate=" + igstRate + ", igstAmount=" + igstAmount
				+ ", grossAmount=" + grossAmount + ", description="
				+ description + "]";
	}

}
