package com.aone.module.vehicleclaimdetail.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.vehicleclaimdetail.constant.VehicleClaimDetailDbColmPojoConstant;

@Entity
@Table(name = "vehicleClaimDetail")
public class VehicleClaimDetail extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038293081957674066L;

	@Column(name=VehicleClaimDetailDbColmPojoConstant.CLAIMED_AMOUNT)
	private long claimedAmount;

	@Column(name=VehicleClaimDetailDbColmPojoConstant.SALES_ORDER_ID)
	private long salesOrderId;
	
	@Column(name=VehicleClaimDetailDbColmPojoConstant.PASSED_AMOUNT)
	private long passedAmount;
	
	@Column(name=VehicleClaimDetailDbColmPojoConstant.DATE)
	private LocalDateTime date;
	
	@Column(name=VehicleClaimDetailDbColmPojoConstant.VEHICLE_INSURANCE_POLICY_ID)
	private long vehicleInsurancePolicyId;

	public long getClaimedAmount() {
		return claimedAmount;
	}

	public void setClaimedAmount(long claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public long getPassedAmount() {
		return passedAmount;
	}

	public void setPassedAmount(long passedAmount) {
		this.passedAmount = passedAmount;
	}

	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public long getVehicleInsurancePolicyId() {
		return vehicleInsurancePolicyId;
	}

	public void setVehicleInsurancePolicyId(long vehicleInsurancePolicyId) {
		this.vehicleInsurancePolicyId = vehicleInsurancePolicyId;
	}

	@Override
	public String toString() {
		return "VehicleClaimDetail [claimedAmount=" + claimedAmount + ", salesOrderId=" + salesOrderId
				+ ", passedAmount=" + passedAmount + ", date=" + date + ", vehicleInsurancePolicyId="
				+ vehicleInsurancePolicyId + "]";
	}
}
