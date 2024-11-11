package com.aone.module.servicespackagedetail.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.servicespackagedetail.constant.ServicesPackageDetailDbColmPojoConstant;

@Entity
@Table(name = "BASE_Category")
public class ServicesPackageDetail extends AbstractBaseMasterEntity<Long> {

	private static final long serialVersionUID = 6038293081954574066L;
	
	@Column(name=ServicesPackageDetailDbColmPojoConstant.PARENT_ID)
	private long parentId;

	@Column(name=ServicesPackageDetailDbColmPojoConstant.SERVICE_ID)
	private String serviceId;
	
	@Column(name=ServicesPackageDetailDbColmPojoConstant.SERVICE_COUNT)
	private String serviceCount;

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(String serviceCount) {
		this.serviceCount = serviceCount;
	}

	@Override
	public String toString() {
		return "ServicesPackageDetail [parentId=" + parentId + ", serviceId=" + serviceId + ", serviceCount="
				+ serviceCount + "]";
	}

}
