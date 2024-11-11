package com.aone.module.vehicleinsurancepolicy.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.aone.corelibrary.model.impl.AbstractBaseMasterEntity;
import com.aone.module.vehicleinsurancepolicy.constant.VehicleInsurancePolicyDbColmPojoConstant;

@Entity
@Table(name = "vehicleInsurancePolicy")
public class VehicleInsurancePolicy extends AbstractBaseMasterEntity<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6038293081754524066L;

	@Column(name=VehicleInsurancePolicyDbColmPojoConstant.VEHICLE_ID)
	private long vehicleId;

	@Column(name=VehicleInsurancePolicyDbColmPojoConstant.POLICY_NO)
	private String policyNo;
	
	@Column(name=VehicleInsurancePolicyDbColmPojoConstant.TOTAL_INSURED_AMOUNT)
	private long totalInsuredAmount;
	
	@Column(name=VehicleInsurancePolicyDbColmPojoConstant.INSURANCE_COMPANY)
	private String insuranceCompany;
	
	@Column(name=VehicleInsurancePolicyDbColmPojoConstant.START_DATE)
	private LocalDateTime startDate;
	
	@Column(name=VehicleInsurancePolicyDbColmPojoConstant.END_DATE)
	private LocalDateTime endDate;
	
	@Column(name=VehicleInsurancePolicyDbColmPojoConstant.INSURANCE_CLAIM_COUNT)
	private long insuranceClaimCount;

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public long getTotalInsuredAmount() {
		return totalInsuredAmount;
	}

	public void setTotalInsuredAmount(long totalInsuredAmount) {
		this.totalInsuredAmount = totalInsuredAmount;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	@Type(type= "org.hibernate.type.OffsetDateTimeType")
	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public long getInsuranceClaimCount() {
		return insuranceClaimCount;
	}

	public void setInsuranceClaimCount(long insuranceClaimCount) {
		this.insuranceClaimCount = insuranceClaimCount;
	}

	@Override
	public String toString() {
		return "VehicleInsurancePolicy [vehicleId=" + vehicleId + ", policyNo=" + policyNo + ", totalInsuredAmount="
				+ totalInsuredAmount + ", insuranceCompany=" + insuranceCompany + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", insuranceClaimCount=" + insuranceClaimCount + "]";
	}

}
