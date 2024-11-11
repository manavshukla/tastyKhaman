package com.aone.module.proFormaDetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.proFormaDetails.constant.ProFormaDetailsDbColPojoConstant;

@Entity
@Table(name = "pro_forma_details")
public class ProFormaDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.SALES_ID)
	private long salesId;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.ITEM_ID)
	private long itemId;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.ITEM_NAME)
	private String itemName;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.SIZE)
	private String size;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.UOM_ID)
	private long uomId;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.HSN_CODE)
	private String hsnCode;

	@Column(name = ProFormaDetailsDbColPojoConstant.QUANTITY)
	private double quantity;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.PRICE)
	private double price;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.DISCOUNT_PERCENTAGE)
	private double discountPercentage;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.DISCOUNT_AMOUNT)
	private double discountAmount;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.CGST_RATE)
	private double cgstRate;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.CGST_AMOUNT)
	private double cgstAmount;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.SGST_RATE)
	private double sgstRate;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.SGST_AMOUNT)
	private double sgstAmount;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.IGST_RATE)
	private double igstRate;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.IGST_AMOUNT)
	private double igstAmount;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.GROSS_AMOUNT)
	private double grossAmount;
	
	@Column(name = ProFormaDetailsDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getSalesId() {
		return salesId;
	}

	public void setSalesId(long salesId) {
		this.salesId = salesId;
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
		return "ProFormaDetails [salesId=" + salesId + ", transactionDate=" + transactionDate + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", size=" + size + ", uomId=" + uomId + ", hsnCode=" + hsnCode
				+ ", quantity=" + quantity + ", price=" + price + ", discountPercentage=" + discountPercentage
				+ ", discountAmount=" + discountAmount + ", cgstRate=" + cgstRate + ", cgstAmount=" + cgstAmount
				+ ", sgstRate=" + sgstRate + ", sgstAmount=" + sgstAmount + ", igstRate=" + igstRate + ", igstAmount="
				+ igstAmount + ", grossAmount=" + grossAmount + ", description=" + description + "]";
	}

}
