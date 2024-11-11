package com.aone.module.saleorderservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.saleorderservices.constant.SaleOrderServicesDbColmPojoConstant;

@Entity
@Table(name = "saleorderservices")
public class SaleOrderServices extends AbstractBaseMasterEntity<Long>{
	
	private static final long serialVersionUID = 6038293081954574066L;
	
	@Column(name=SaleOrderServicesDbColmPojoConstant.APPOINTMENT_ID)
	private long appointmentId;

	@Column(name=SaleOrderServicesDbColmPojoConstant.MECHANIC_ID)
	private long mechanicId;
	
	@Column(name=SaleOrderServicesDbColmPojoConstant.SALE_ORDER_ID)
	private long saleOrderId;
	
	@Column(name=SaleOrderServicesDbColmPojoConstant.SERVICES_ID)
	private long servicesId;

	@Column(name=SaleOrderServicesDbColmPojoConstant.THIRD_PARTY_CONTACT_ID)
	private long thirdPartyContactId;

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public long getMechanicId() {
		return mechanicId;
	}

	public void setMechanicId(long mechanicId) {
		this.mechanicId = mechanicId;
	}

	public long getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(long saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public long getServicesId() {
		return servicesId;
	}

	public void setServicesId(long servicesId) {
		this.servicesId = servicesId;
	}

	public long getThirdPartyContactId() {
		return thirdPartyContactId;
	}

	public void setThirdPartyContactId(long thirdPartyContactId) {
		this.thirdPartyContactId = thirdPartyContactId;
	}

	@Override
	public String toString() {
		return "SaleOrderServices [appointmentId=" + appointmentId + ", mechanicId=" + mechanicId + ", saleOrderId="
				+ saleOrderId + ", servicesId=" + servicesId + ", thirdPartyContactId=" + thirdPartyContactId + "]";
	}
	
}
