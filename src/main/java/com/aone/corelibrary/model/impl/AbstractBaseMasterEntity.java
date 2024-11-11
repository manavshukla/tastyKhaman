package com.aone.corelibrary.model.impl;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.aone.corelibrary.model.IBaseMasterEntity;

@MappedSuperclass
public abstract class AbstractBaseMasterEntity<K extends Serializable> extends AbstractBaseEntity<K> implements IBaseMasterEntity<K> {

	private static final long serialVersionUID = 4122635316497011796L;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdby")*/
	@Column(name = "createdby")
	private long createdBy;

	/*@Temporal(TemporalType.TIMESTAMP)*/
	@Column(name = "createdOn")
	private LocalDateTime createdOn;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updatedby")*/
	@Column(name = "updatedby")
	private long updatedBy;

	/*@Temporal(TemporalType.TIMESTAMP)*/
	@Column(name = "updatedOn")
	private LocalDateTime updatedOn;

	@Column
	private long financialYear;

	/*@Temporal(TemporalType.TIMESTAMP)*/
	@Column(name = "deletedOn")
	private LocalDateTime deletedOn;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deletedby")*/
	@Column(name = "deletedby")
	private long deletedBy;

	@Column(name = "IsActive")
	private boolean active;
	
	public AbstractBaseMasterEntity(){
		super();
		createdOn = LocalDateTime.now();
		updatedBy = createdBy;
		active = true;
	}
	
	@Override
	public boolean setDefaultValueForObject() {
		return true;
	}
	
	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	public long getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(long financialYear) {
		this.financialYear = financialYear;
	}

	public long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(long deletedBy) {
		this.deletedBy = deletedBy;
	}

	public LocalDateTime getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(LocalDateTime deletedOn) {
		this.deletedOn = deletedOn;
	}

	@Override
	public String toString() {
		return super.toString() + "AbstractBaseMasterEntity [createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + ", financialYear="
				+ financialYear + ", deletedOn=" + deletedOn + ", deletedBy="
				+ deletedBy + ", active=" + active + "]";
	}
	
}
