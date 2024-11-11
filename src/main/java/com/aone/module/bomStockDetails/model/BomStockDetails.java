package com.aone.module.bomStockDetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.bomStockDetails.constant.BomStockDetailsDbColPojoConstant;

@Entity
@Table(name = "bom_stock_details")
public class BomStockDetails extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -3283165044313532989L;
	
	@Column(name = BomStockDetailsDbColPojoConstant.BOM_ID)
	private long bomId;

	@Column(name = BomStockDetailsDbColPojoConstant.TRANSACTION_DATE)
	private LocalDateTime transactionDate;

	@Column(name = BomStockDetailsDbColPojoConstant.QUANTITY)
	private double quantity;

	@Column(name = BomStockDetailsDbColPojoConstant.DESCRIPTION)
	private String description;

	public long getBomId() {
		return bomId;
	}

	public void setBomId(long bomId) {
		this.bomId = bomId;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BomStockDetails [bomId=" + bomId + ", transactionDate=" + transactionDate + ", quantity=" + quantity
				+ ", description=" + description + "]";
	}

}
