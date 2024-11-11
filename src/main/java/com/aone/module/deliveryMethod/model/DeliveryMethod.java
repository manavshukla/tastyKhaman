package com.aone.module.deliveryMethod.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.deliveryMethod.constant.DeliveryMethodDbColPojoConstant;

/**
 * The Class Contact.
 */
@Entity
@Table(name = "delivery_method")
public class DeliveryMethod extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 8458610990260785539L;

	@Column(name = DeliveryMethodDbColPojoConstant.NAME)
	private String name;

	@Column(name = DeliveryMethodDbColPojoConstant.DESCRIPTION)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DeliveryMethod [name=" + name + ", description=" + description + "]";
	}
	
}
