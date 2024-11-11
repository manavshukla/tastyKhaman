package com.aone.corelibrary.model.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.aone.corelibrary.model.IBaseEntity;

@MappedSuperclass
public abstract class AbstractBaseEntity<K extends Serializable> implements IBaseEntity<K>, Serializable {

	private static final long serialVersionUID = -108032017;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	K id;
	
	@Column
	private boolean deleted;
	
	@Override
	public boolean setDefaultValueForObject() {
		return true;
	}
	
	public AbstractBaseEntity() {
		deleted = false;
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "AbstractBaseEntity [id=" + id + ", deleted=" + deleted + "]";
	}

}
