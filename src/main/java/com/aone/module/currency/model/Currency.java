package com.aone.module.currency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.currency.constant.CurrencyDbColPojoConstant;

@Entity
@Table(name = "currency")
public class Currency extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = -8119538642670988449L;

	@Column(name = CurrencyDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = CurrencyDbColPojoConstant.SYMBOL)
	private String symbol;
	
	@Column(name = CurrencyDbColPojoConstant.SYMBOL_PATH)
	private String symbolPath;
	
	@Column(name = CurrencyDbColPojoConstant.DESCRIPTION)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbolPath() {
		return symbolPath;
	}

	public void setSymbolPath(String symbolPath) {
		this.symbolPath = symbolPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + ", description=" + description + "]";
	}

}
