package com.aone.module.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.services.constant.ServicesDbColmPojoConstant;

@Entity
@Table(name = "service")
public class Services extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038293081954574066L;

	@Column(name=ServicesDbColmPojoConstant.CATEGORY_ID)
	private long parentServiceCategoryId;

	@Column(name=ServicesDbColmPojoConstant.NAME)
	private String name;
	
	@Column(name=ServicesDbColmPojoConstant.PRICE)
	private long price;
	
	@Column(name=ServicesDbColmPojoConstant.DURATION)
	private String duration;

	public long getParentServiceCategoryId() {
		return parentServiceCategoryId;
	}

	public void setParentServiceCategoryId(long parentServiceCategoryId) {
		this.parentServiceCategoryId = parentServiceCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Services [parentServiceCategoryId=" + parentServiceCategoryId + ", name=" + name + ", price=" + price
				+ ", duration=" + duration + "]";
	}

}
