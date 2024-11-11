package com.aone.module.vehicleclaimdetail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.vehicleclaimdetail.dao.IVehicleClaimDetailDao;
import com.aone.module.vehicleclaimdetail.model.VehicleClaimDetail;
import com.aone.module.vehicleclaimdetail.service.IVehicleClaimDetailService;

@Lazy
@Service("vehicleClaimDetailServiceImpl")
public class VehicleClaimDetailServiceImpl extends AbstractBaseMasterService<VehicleClaimDetail, Long, IVehicleClaimDetailDao> implements IVehicleClaimDetailService {

	private IVehicleClaimDetailDao vehicleClaimDetailDao;
	
	@Override
	public IVehicleClaimDetailDao getRepository() {
		return getVehicleClaimDetailDao();
	}

	public IVehicleClaimDetailDao getVehicleClaimDetailDao() {
		return vehicleClaimDetailDao;
	}

	@Autowired
	@Qualifier(value = "vehicleClaimDetailDaoImpl")
	public void setVehicleClaimDetailDao(IVehicleClaimDetailDao vehicleClaimDetailDao) {
		this.vehicleClaimDetailDao = vehicleClaimDetailDao;
	}
	
	@Override
	public ResultCodeConstant validateData(VehicleClaimDetail vehicleClaimDetail) {
		if(vehicleClaimDetail == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}

		if(vehicleClaimDetail.getClaimedAmount() <= 0) {
			return ResultCodeConstant.VEHICLE_CLAIM_DETAIL_CLAIMED_AMOUNT;
		}
		
		if(vehicleClaimDetail.getSalesOrderId() <= 0) { 
			return ResultCodeConstant.VEHICLE_CLAIM_DETAIL_SALES_ORDER_ID;
		}
		
		if(vehicleClaimDetail.getPassedAmount() < 0) { 
			return ResultCodeConstant.VEHICLE_CLAIM_DETAIL_PASSED_AMOUNT;
		}
		
		if(vehicleClaimDetail.getVehicleInsurancePolicyId() <= 0) { 
			return ResultCodeConstant.VEHICLE_CLAIM_DETAIL_PASSED_AMOUNT;
		}
		
		if(vehicleClaimDetail.getDate() == null || vehicleClaimDetail.getDate().toString().isEmpty()) {
			return ResultCodeConstant.VEHICLE_CLAIM_DETAIL_DATE;
		}
		
		return ResultCodeConstant.SUCCESS;
	}
}