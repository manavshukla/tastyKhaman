package com.aone.module.billOfMaterialDetail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.billOfMaterialDetail.constant.BillOfMaterialDetailDbColPojoConstant;

@Entity
@Table(name = "bill_of_material_detail")
public class BillOfMaterialDetail extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = BillOfMaterialDetailDbColPojoConstant.BOM_ID)
	private long bomId;
	
	@Column(name = BillOfMaterialDetailDbColPojoConstant.ITEM_ID)
	private long itemId;
	
	@Column(name = BillOfMaterialDetailDbColPojoConstant.QUANTITY)
	private double quantity;
	
	@Column(name = BillOfMaterialDetailDbColPojoConstant.PRICE)
	private double price;
	
	@Column(name = BillOfMaterialDetailDbColPojoConstant.TOTAL_AMOUNT)
	private double totalAmount;
	
	@Column(name = BillOfMaterialDetailDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getBomId() {
		return bomId;
	}

	public void setBomId(long bomId) {
		this.bomId = bomId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BillOfMaterialDetail [bomId=" + bomId + ", itemId=" + itemId + ", quantity=" + quantity + ", price="
				+ price + ", totalAmount=" + totalAmount + ", description=" + description + "]";
	}

}
