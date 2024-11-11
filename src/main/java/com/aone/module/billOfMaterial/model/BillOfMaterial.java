package com.aone.module.billOfMaterial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.billOfMaterial.constant.BillOfMaterialDbColPojoConstant;

@Entity
@Table(name = "bill_of_material")
public class BillOfMaterial extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;

	@Column(name = BillOfMaterialDbColPojoConstant.CODE)
	private String code;

	@Column(name = BillOfMaterialDbColPojoConstant.NAME)
	private String name;

	@Column(name = BillOfMaterialDbColPojoConstant.PRICE)
	private double price;

	@Column(name = BillOfMaterialDbColPojoConstant.GST_RATE_ID)
	private long gstRateId;

	@Column(name = BillOfMaterialDbColPojoConstant.STOCK)
	private double stock;

	@Column(name = BillOfMaterialDbColPojoConstant.UOM_ID)
	private long uomId;

	@Column(name = BillOfMaterialDbColPojoConstant.DESCRIPTION)
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getGstRateId() {
		return gstRateId;
	}

	public void setGstRateId(long gstRateId) {
		this.gstRateId = gstRateId;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public long getUomId() {
		return uomId;
	}

	public void setUomId(long uomId) {
		this.uomId = uomId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BillOfMaterial [code=" + code + ", name=" + name + ", price="
				+ price + ", gstRateId=" + gstRateId + ", stock=" + stock
				+ ", uomId=" + uomId + ", description=" + description + "]";
	}

}
