package com.aone.module.item.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.item.constant.ItemDbColPojoConstant;
import com.aone.module.itemCategory.model.ItemCategory;

@Entity
@Table(name = "item_master")
public class Item extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 2720214281416012405L;

	
	@Column(name = ItemDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = ItemDbColPojoConstant.CATEGORY_ID)
	private long categoryId;
	
	@Column(name = ItemDbColPojoConstant.ORDER_TYPE)
	private String orderType;
	
	// purchase related fields
	@Column(name = ItemDbColPojoConstant.PRICE)
	private double price;	
	
	@Column(name = ItemDbColPojoConstant.DESCRIPTION)
	private String description;

	@Column(name = ItemDbColPojoConstant.BASE_PRICE)
	private String basePrice;
	
	@Column(name = ItemDbColPojoConstant.THALWEIGHT)
	private String thalWeight;
	
	@Column(name = ItemDbColPojoConstant.STOCK)
	private double stock;
	
	@Column(name = ItemDbColPojoConstant.LAST_UPDATED_DATE_TIME)
	private LocalDateTime lastUpdatedDateTime;
	
	@Transient
	private ItemInitData itemInitData;
	
	@Transient
	private ItemCategory itemCategory;

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public String getBasePrice() {
		return basePrice;
	}

	public String getThalWeight() {
		return thalWeight;
	}

	public void setThalWeight(String thalWeight) {
		this.thalWeight = thalWeight;
	}

	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}

	public String getMinQty() {
		return minQty;
	}

	public void setMinQty(String minQty) {
		this.minQty = minQty;
	}

	@Column(name = ItemDbColPojoConstant.MINQTY)
	private String minQty;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public ItemInitData getItemInitData() {
		return itemInitData;
	}

	public void setItemInitData(ItemInitData itemInitData) {
		this.itemInitData = itemInitData;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", categoryId=" + categoryId + ", orderType=" + orderType + ", price=" + price
				+ ", description=" + description + ", basePrice=" + basePrice + ", thalWeight=" + thalWeight
				+ ", stock=" + stock + ", itemInitData=" + itemInitData + ", itemCategory=" + itemCategory + ", minQty="
				+ minQty + "]";
	}	
}
