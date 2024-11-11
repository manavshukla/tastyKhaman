package com.aone.module.appointmentorderdetails.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.appointmentorderdetails.constant.AppointmentOrderDetailsDbColmPojoConstant;

@Entity
@Table(name = "appointmentorderdetails")
public class AppointmentOrderDetails extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038293081954574066L;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.CONTACT_ID)
	private long contactId;

	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.CONTACT_VEHICLE_DETAILS_ID)
	private long contactVehicleDetailsId;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.CREATED_BY_ID)
	private long createdById;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.DATE_TIME_OF_APPT)
	private LocalDateTime dateTimeOfAppointment;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.DROP_DATE_TIME)
	private LocalDateTime dropDateTime;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.PICKUP_DATE_TIME)
	private LocalDateTime pickUpDateTime;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.DROP_DRIVER_ID)
	private long dropDriverId;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.PICKUP_DRIVER_ID)
	private long pickUpDriverId;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.IS_TELEPHONIC)
	private boolean isTelephonic;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.SUPERVISOR_ID)
	private long supervisorId;
	
	@Column(name=AppointmentOrderDetailsDbColmPojoConstant.KILOMETERS)
	private long kilometers;

	public long getContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public long getContactVehicleDetailsId() {
		return contactVehicleDetailsId;
	}

	public void setContactVehicleDetailsId(long contactVehicleDetailsId) {
		this.contactVehicleDetailsId = contactVehicleDetailsId;
	}

	public long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(long createdById) {
		this.createdById = createdById;
	}

	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getDateTimeOfAppointment() {
		return dateTimeOfAppointment;
	}

	public void setDateTimeOfAppointment(LocalDateTime dateTimeOfAppointment) {
		this.dateTimeOfAppointment = dateTimeOfAppointment;
	}

	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getDropDateTime() {
		return dropDateTime;
	}

	public void setDropDateTime(LocalDateTime dropDateTime) {
		this.dropDateTime = dropDateTime;
	}

	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getPickUpDateTime() {
		return pickUpDateTime;
	}

	public void setPickUpDateTime(LocalDateTime pickUpDateTime) {
		this.pickUpDateTime = pickUpDateTime;
	}

	public long getDropDriverId() {
		return dropDriverId;
	}

	public void setDropDriverId(long dropDriverId) {
		this.dropDriverId = dropDriverId;
	}

	public long getPickUpDriverId() {
		return pickUpDriverId;
	}

	public void setPickUpDriverId(long pickUpDriverId) {
		this.pickUpDriverId = pickUpDriverId;
	}

	public boolean isTelephonic() {
		return isTelephonic;
	}

	public void setTelephonic(boolean isTelephonic) {
		this.isTelephonic = isTelephonic;
	}

	public long getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(long supervisorId) {
		this.supervisorId = supervisorId;
	}

	public long getKilometers() {
		return kilometers;
	}

	public void setKilometers(long kilometers) {
		this.kilometers = kilometers;
	}

	@Override
	public String toString() {
		return "AppointmentOrderDetails [contactId=" + contactId + ", contactVehicleDetailsId="
				+ contactVehicleDetailsId + ", createdById=" + createdById + ", dateTimeOfAppointment="
				+ dateTimeOfAppointment + ", dropDateTime=" + dropDateTime + ", pickUpDateTime=" + pickUpDateTime
				+ ", dropDriverId=" + dropDriverId + ", pickUpDriverId=" + pickUpDriverId + ", isTelephonic="
				+ isTelephonic + ", supervisorId=" + supervisorId + ", kilometers=" + kilometers + "]";
	}
	
}
