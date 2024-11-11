package com.aone.module.vehicleinsurancepolicy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.vehicleinsurancepolicy.dao.IVehicleInsurancePolicyDao;
import com.aone.module.vehicleinsurancepolicy.model.VehicleInsurancePolicy;
import com.aone.module.vehicleinsurancepolicy.service.IVehicleInsurancePolicyService;

@Lazy
@Service("vehicleInsurancePolicyServiceImpl")
public class VehicleInsurancePolicyServiceImpl extends AbstractBaseMasterService<VehicleInsurancePolicy, Long, IVehicleInsurancePolicyDao> implements IVehicleInsurancePolicyService {

	private IVehicleInsurancePolicyDao vehicleInsurancePolicyDao;
	
	@Override
	public IVehicleInsurancePolicyDao getRepository() {
		return getVehicleInsurancePolicyDao();
	}

	public IVehicleInsurancePolicyDao getVehicleInsurancePolicyDao() {
		return vehicleInsurancePolicyDao;
	}

	@Autowired
	@Qualifier(value = "vehicleInsurancePolicyDaoImpl")
	public void setServicesDao(IVehicleInsurancePolicyDao vehicleInsurancePolicyDao) {
		this.vehicleInsurancePolicyDao = vehicleInsurancePolicyDao;
	}
	
	
	public ResultCodeConstant validateData(VehicleInsurancePolicy vehicleInsurancePolicyDao) {
		if(vehicleInsurancePolicyDao == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		// validate name
			/*	if(service.getName() == null || service.getName().isEmpty()) {
					return ResultCodeConstant.ITEM_CATEGORY_NAME_NOT_FOUND;
				}
				// check if category name already exist
				if(!getRepository().checkUniqueDataByField("name", service.getName(), "id", service.getId()).isEmpty()) {
					return ResultCodeConstant.ITEM_CATEGORY_NAME_ALREADY_EXIST;
				}
				
				if(item.getCategoryId() == 0) {
					return ResultCodeConstant.ITEM_CATEGORY_REQURIED;
				}

				if(item.getUomId() == 0) {
					return ResultCodeConstant.ITEM_UOM_REQURIED;
				}

				if(item.getPurchaseGSTRateId() == 0) {
					return ResultCodeConstant.ITEM_PURCHASE_GST_RATE_REQURIED;
				}

				if(item.getSaleLedgerId() == 0) {
					return ResultCodeConstant.ITEM_SALE_GST_RATE_REQURIED;
				}
				
				if(item.getPurchasePrice() < 0) {
					return ResultCodeConstant.ITEM_PURCHASE_GT_ZERO;
				}
				
				if(item.getSalePrice() < 0) {
					return ResultCodeConstant.ITEM_SALE_GT_ZERO;
				}
				
				if(item.getReOrderLevel() < 0) {
					return ResultCodeConstant.ITEM_ROL_GT_ZERO;
				}*/
				return ResultCodeConstant.SUCCESS;
	}
}