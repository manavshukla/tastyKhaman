package com.aone.module.salutation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.salutation.constant.SalutationDbColPojoConstant;

@Entity
@Table(name = "salutation")
public class Salutation extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 7895104325035517069L;
	
	@Column(name = SalutationDbColPojoConstant.NAME)
	private String name;
	
	@Column(name = SalutationDbColPojoConstant.DESCRIPTION)
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
		return "Salutation [name=" + name + ", description=" + description + "]";
	}

}
