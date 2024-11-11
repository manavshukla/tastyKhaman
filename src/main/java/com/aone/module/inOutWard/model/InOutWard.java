package com.aone.module.inOutWard.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.inOutWard.constant.InOutWardDbColPojoConstant;

@Entity
@Table(name = "in_out_ward")
public class InOutWard extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 2720214281416012405L;

	@Column(name = InOutWardDbColPojoConstant.DATE)
	private LocalDateTime date;

	@Column(name = InOutWardDbColPojoConstant.ITEM_ID)
	private long itemId;

	@Column(name = InOutWardDbColPojoConstant.CONTACT_ID)
	private long contactId;

	@Column(name = InOutWardDbColPojoConstant.QUANTITY)
	private double quantity;

	@Column(name = InOutWardDbColPojoConstant.PRICE)
	private double price;

	@Column(name = InOutWardDbColPojoConstant.DISCOUNT_AMT)
	private double discountAmt;

	@Column(name = InOutWardDbColPojoConstant.DISCOUNT_PERCENTAGE)
	private double discountPercentage;

	@Column(name = InOutWardDbColPojoConstant.TOTAL_AMT)
	private double totalAmount;

	@Column(name = InOutWardDbColPojoConstant.PURCHASE_ID)
	private long purchaseId;

	@Column(name = InOutWardDbColPojoConstant.SALE_ID)
	private long saleId;

	@Column(name = InOutWardDbColPojoConstant.PURCHASE_RETURN_ID)
	private long purchaseReturnId;

	@Column(name = InOutWardDbColPojoConstant.SALE_RETURN_ID)
	private long saleReturnId;

	@Column(name = InOutWardDbColPojoConstant.SOURCE)
	private String source;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
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

	public double getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(double discountAmt) {
		this.discountAmt = discountAmt;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public long getSaleId() {
		return saleId;
	}

	public void setSaleId(long saleId) {
		this.saleId = saleId;
	}

	public long getPurchaseReturnId() {
		return purchaseReturnId;
	}

	public void setPurchaseReturnId(long purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}

	public long getSaleReturnId() {
		return saleReturnId;
	}

	public void setSaleReturnId(long saleReturnId) {
		this.saleReturnId = saleReturnId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "InOutWard [date=" + date + ", itemId=" + itemId + ", contactId=" + contactId + ", quantity=" + quantity + ", price=" + price + ", discountAmt=" + discountAmt + ", discountPercentage=" + discountPercentage
				+ ", totalAmount=" + totalAmount + ", purchaseId=" + purchaseId + ", saleId=" + saleId + ", purchaseReturnId=" + purchaseReturnId + ", saleReturnId=" + saleReturnId + ", source=" + source + "]";
	}

}
