package com.aone.module.salesDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.item.model.Item;
import com.aone.module.salesDetails.constant.SalesDetailsDbColPojoConstant;

@Entity
@Table(name = "sales_details")
public class SalesDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = SalesDetailsDbColPojoConstant.SALES_ID)
	private long salesId;
	
	@Column(name = SalesDetailsDbColPojoConstant.ITEM_ID)
	private long itemId;
	
	@Column(name = SalesDetailsDbColPojoConstant.ORDER_QUANTITY)
	private double orderQuantity;
	
	@Column(name = SalesDetailsDbColPojoConstant.CHARGED_QUANTITY)
	private double chargedQuantity;
	
	@Column(name = SalesDetailsDbColPojoConstant.PRICE)
	private double price;
	
	@Column(name = SalesDetailsDbColPojoConstant.THAL_WEIGHT)
	private double thalWeight;

	@Column(name = SalesDetailsDbColPojoConstant.NO_OF_THAL)
	private double noOfThal;
	
	@Column(name = SalesDetailsDbColPojoConstant.TOTAL_PRICE)
	private double totalPrice;
	
	@Column(name = SalesDetailsDbColPojoConstant.DESCRIPTION)
	private String description;
	
	@Transient
	private Item item;

	public long getSalesId() {
		return salesId;
	}

	public void setSalesId(long salesId) {
		this.salesId = salesId;
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

	public double getChargedQuantity() {
		return chargedQuantity;
	}

	public void setChargedQuantity(double chargedQuantity) {
		this.chargedQuantity = chargedQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getThalWeight() {
		return thalWeight;
	}

	public void setThalWeight(double thalWeight) {
		this.thalWeight = thalWeight;
	}

	public double getNoOfThal() {
		return noOfThal;
	}

	public void setNoOfThal(double noOfThal) {
		this.noOfThal = noOfThal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "SalesDetails [salesId=" + salesId + ", itemId=" + itemId + ", orderQuantity=" + orderQuantity
				+ ", chargedQuantity=" + chargedQuantity + ", price=" + price + ", thalWeight=" + thalWeight
				+ ", noOfThal=" + noOfThal + ", totalPrice=" + totalPrice + ", description=" + description + ", item="
				+ item + "]";
	}
}
