package com.aone.module.vehicleclaimdetail.dao.impl;

import org.springframework.context.annotation.Lazy; 
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.vehicleclaimdetail.dao.IVehicleClaimDetailDao;
import com.aone.module.vehicleclaimdetail.model.VehicleClaimDetail;

@Lazy
@Repository("vehicleClaimDetailDaoImpl")
public class VehicleClaimDetailDaoImpl extends AbstractBaseMasterRepository<VehicleClaimDetail, Long> implements IVehicleClaimDetailDao{

	@Override
	public Class<VehicleClaimDetail> getClazz() {
		return VehicleClaimDetail.class;
	}

}
