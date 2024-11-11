package com.aone.module.quotationDetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.quotationDetails.constant.QuotationDetailsDbColPojoConstant;

@Entity
@Table(name = "quotation_details")
public class QuotationDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = QuotationDetailsDbColPojoConstant.QUOTATION_ID)
	private long quotationId;
	
	@Column(name = QuotationDetailsDbColPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;
	
	@Column(name = QuotationDetailsDbColPojoConstant.ITEM_ID)
	private long itemId;
	
	@Column(name = QuotationDetailsDbColPojoConstant.ITEM_NAME)
	private String itemName;
	
	@Column(name = QuotationDetailsDbColPojoConstant.SIZE)
	private String size;
	
	@Column(name = QuotationDetailsDbColPojoConstant.UOM_ID)
	private long uomId;
	
	@Column(name = QuotationDetailsDbColPojoConstant.HSN_CODE)
	private String hsnCode;

	@Column(name = QuotationDetailsDbColPojoConstant.QUANTITY)
	private double quantity;
	
	@Column(name = QuotationDetailsDbColPojoConstant.PRICE)
	private double price;
	
	@Column(name = QuotationDetailsDbColPojoConstant.DISCOUNT_PERCENTAGE)
	private double discountPercentage;
	
	@Column(name = QuotationDetailsDbColPojoConstant.DISCOUNT_AMOUNT)
	private double discountAmount;
	
	@Column(name = QuotationDetailsDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
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
		return "QuotationDetails [quotationId=" + quotationId + ", transactionDate=" + transactionDate + ", itemId="
				+ itemId + ", itemName=" + itemName + ", size=" + size + ", uomId=" + uomId + ", hsnCode=" + hsnCode
				+ ", quantity=" + quantity + ", price=" + price + ", discountPercentage=" + discountPercentage
				+ ", discountAmount=" + discountAmount + ", description=" + description + "]";
	}

}
