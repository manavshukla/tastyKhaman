package com.aone.corelibrary.model.impl;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractBaseMasterLongKeyEntity<K extends Serializable> extends AbstractBaseMasterEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8901840064565446459L;

	@Override
	public Long getId() {
		if(super.getId() == null) {
			return 0L;
		}
		return super.getId();
	}
	
	@Override
	public void setId(Long id) {
		if(id != null && id == 0) {
			id = null;
		}
		this.id = id; 
	}
}
