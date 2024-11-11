package com.aone.module.saleorderservices.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.saleorderservices.dao.ISaleOrderServicesDao;
import com.aone.module.saleorderservices.model.SaleOrderServices;

@Lazy
@Repository("saleOrderServicesDaoImpl")
public class SaleOrderServicesDaoImpl  extends AbstractBaseMasterRepository<SaleOrderServices, Long> implements ISaleOrderServicesDao{

	@Override
	public Class<SaleOrderServices> getClazz() {
		return SaleOrderServices.class;
	}
	
	public ResultCodeConstant validateData(SaleOrderServices saleOrderServices) {
		if(saleOrderServices == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		// validate
			if(saleOrderServices.getAppointmentId() == 0) {
				return ResultCodeConstant.SALE_ORDER_SERVICE_APPOINTMENT_ID;
			}
			
			if(saleOrderServices.getServicesId() == 0) {
				return ResultCodeConstant.SALE_ORDER_SERVICE_SERVICES_ID;
			}
			if(saleOrderServices.getMechanicId() == 0) {
				return ResultCodeConstant.SALE_ORDER_SERVICE_MECHANIC_ID;
			}
				
		return ResultCodeConstant.SUCCESS;
	}

}
