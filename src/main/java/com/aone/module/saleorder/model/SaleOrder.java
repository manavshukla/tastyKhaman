package com.aone.module.saleorder.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.saleorder.constant.SaleOrderDbColmPojoConstant;

@Entity
@Table(name = "saleorder")
public class SaleOrder extends AbstractBaseMasterEntity<Long> {
	
	private static final long serialVersionUID = 6038293081954574098L;
	
	@Column(name=SaleOrderDbColmPojoConstant.CONTACT_ID)
	private long contactId;

	@Column(name=SaleOrderDbColmPojoConstant.APPOINTMENT_ID)
	private long appointmentId;
	
	@Column(name=SaleOrderDbColmPojoConstant.ORDER_DATE)
	private LocalDateTime orderDate;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getPrice() {
		return orderDate;
	}

	public void setPrice(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "SaleOrder [contactId=" + contactId + ", appointmentId=" + appointmentId + ", orderDate=" + orderDate + "]";
	}
}
