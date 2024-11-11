package com.aone.module.purchaseDetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.purchaseDetails.constant.PurchaseDetailsDbColPojoConstant;

@Entity
@Table(name = "purchase_details")
public class PurchaseDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = PurchaseDetailsDbColPojoConstant.PURCHASE_ID)
	private long purchaseId;
	
	@Column(name = PurchaseDetailsDbColPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;
	
	@Column(name = PurchaseDetailsDbColPojoConstant.ITEM_ID)
	private long itemId;
	
	@Column(name = PurchaseDetailsDbColPojoConstant.ORDER_QUANTITY)
	private double orderQuantity;
	
	@Column(name = PurchaseDetailsDbColPojoConstant.RETURN_QUANTITY)
	private double returnQty;
	
	@Column(name = PurchaseDetailsDbColPojoConstant.PRICE)
	private double price;
	
	@Column(name = PurchaseDetailsDbColPojoConstant.TOTAL_PRICE)
	private double totalPrice;
	
	@Column(name = PurchaseDetailsDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
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

	public double getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(double returnQty) {
		this.returnQty = returnQty;
	}

	@Override
	public String toString() {
		return "PurchaseDetails [purchaseId=" + purchaseId + ", itemId=" + itemId + ", orderQuantity=" + orderQuantity
				+ ", returnQty=" + returnQty + ", price=" + price + ", totalPrice=" + totalPrice + ", description="
				+ description + "]";
	}
}
