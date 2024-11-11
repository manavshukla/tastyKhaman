package com.aone.module.vehicleinsurancepolicy.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.vehicleinsurancepolicy.dao.IVehicleInsurancePolicyDao;
import com.aone.module.vehicleinsurancepolicy.model.VehicleInsurancePolicy;

@Lazy
@Repository("vehicleInsurancePolicyDaoImpl")
public class VehicleInsurancePolicyDaoImpl extends AbstractBaseMasterRepository<VehicleInsurancePolicy, Long> implements IVehicleInsurancePolicyDao{

	@Override
	public Class<VehicleInsurancePolicy> getClazz() {
		return VehicleInsurancePolicy.class;
	}

}
