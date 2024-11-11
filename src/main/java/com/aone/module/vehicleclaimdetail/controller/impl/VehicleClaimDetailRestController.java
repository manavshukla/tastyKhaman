package com.aone.module.vehicleclaimdetail.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.vehicleclaimdetail.controller.IVehicleClaimDetailController;
import com.aone.module.vehicleclaimdetail.model.VehicleClaimDetail;
import com.aone.module.vehicleclaimdetail.service.IVehicleClaimDetailService;

@RestController
@RequestMapping("/rest/vehicleclaimdetail")
public class VehicleClaimDetailRestController extends AbstractBaseMasterRestController<VehicleClaimDetail, Long, IVehicleClaimDetailService> implements IVehicleClaimDetailController{

	private IVehicleClaimDetailService vehicleClaimDetailService;
	
	@Override
	public IVehicleClaimDetailService getService() {
		return getVehicleClaimDetailService();
	}

	public IVehicleClaimDetailService getVehicleClaimDetailService() {
		return vehicleClaimDetailService;
	}

	@Autowired
	@Qualifier(value="vehicleClaimDetailServiceImpl")
	public void setVehicleClaimDetailService(IVehicleClaimDetailService vehicleClaimDetailService) {
		this.vehicleClaimDetailService = vehicleClaimDetailService;
	}

}
