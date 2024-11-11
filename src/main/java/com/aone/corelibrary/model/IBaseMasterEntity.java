package com.aone.corelibrary.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface IBaseMasterEntity<K extends Serializable> extends IBaseEntity<K> {

	public long getCreatedBy();

	public void setCreatedBy(long createdBy);

	public LocalDateTime getCreatedOn();

	public void setCreatedOn(LocalDateTime createdOn);

	public long getUpdatedBy();

	public void setUpdatedBy(long updatedBy);

	public LocalDateTime getUpdatedOn();

	public void setUpdatedOn(LocalDateTime updatedOn);

	public boolean isActive();

	public void setActive(boolean isActive);

	public long getFinancialYear();

	public void setFinancialYear(long financialYear);

	public long getDeletedBy();

	public void setDeletedBy(long deletedBy);

	public LocalDateTime getDeletedOn();

	public void setDeletedOn(LocalDateTime deletedOn);
	
	public boolean setDefaultValueForObject();
	
}
