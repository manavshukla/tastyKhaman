package com.aone.module.purchaseReturnDetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.purchaseReturnDetails.constant.PurchaseReturnDetailsDbColPojoConstant;

@Entity
@Table(name = "purchase_return_details")
public class PurchaseReturnDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant .PURCHASE_RETURN_ID)
	private long purchaseReturnId;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.ITEM_ID)
	private long itemId;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.ITEM_NAME)
	private String itemName;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.SIZE)
	private String size;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.UOM_ID)
	private long uomId;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.HSN_CODE)
	private String hsnCode;

	@Column(name = PurchaseReturnDetailsDbColPojoConstant.QUANTITY)
	private double quantity;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.PRICE)
	private double price;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.DISCOUNT_PERCENTAGE)
	private double discountPercentage;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.DISCOUNT_AMOUNT)
	private double discountAmount;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.CGST_RATE)
	private double cgstRate;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.CGST_AMOUNT)
	private double cgstAmount;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.SGST_RATE)
	private double sgstRate;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.SGST_AMOUNT)
	private double sgstAmount;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.IGST_RATE)
	private double igstRate;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.IGST_AMOUNT)
	private double igstAmount;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = PurchaseReturnDetailsDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getPurchaseReturnId() {
		return purchaseReturnId;
	}

	public void setPurchaseReturnId(long purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
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
		return "PurchaseReturnDetails [purchaseReturnId=" + purchaseReturnId
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
