package com.aone.module.saleorderservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.saleorderservices.dao.ISaleOrderServicesDao;
import com.aone.module.saleorderservices.model.SaleOrderServices;
import com.aone.module.saleorderservices.service.ISaleOrderServicesService;

@Lazy
@Service("saleOrderServicesServiceImpl")
public class SaleOrderServicesServiceImpl extends AbstractBaseMasterService<SaleOrderServices, Long, ISaleOrderServicesDao> implements ISaleOrderServicesService{

	private ISaleOrderServicesDao saleOrderServicesDao;
	
	@Override
	public ISaleOrderServicesDao getRepository() {
		return getSaleOrderServicesDao();
	}
	
	public ISaleOrderServicesDao getSaleOrderServicesDao() {
		return saleOrderServicesDao;
	}
	
	@Autowired
	@Qualifier(value = "saleOrderServicesDaoImpl")
	public void setSaleOrderServicesDao(ISaleOrderServicesDao saleOrderServicesDao) {
		this.saleOrderServicesDao = saleOrderServicesDao;
	}

	public ResultCodeConstant validateData(SaleOrderServices saleOrderServices) {
		if(saleOrderServices == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		if(saleOrderServices.getAppointmentId() > 0) {
			return ResultCodeConstant.SALE_ORDER_SERVICE_APPOINTMENT_ID;
		}
		
		if(saleOrderServices.getMechanicId() > 0) {
			return ResultCodeConstant.SALE_ORDER_SERVICE_MECHANIC_ID;
		}
		
		if(saleOrderServices.getServicesId() > 0) {
			return ResultCodeConstant.SALE_ORDER_SERVICE_SERVICES_ID;
		}
		
		if(saleOrderServices.getSaleOrderId() > 0) {
			return ResultCodeConstant.SALE_ORDER_SERVICE_SALE_ORDER_ID;
		}
		
		
		return ResultCodeConstant.SUCCESS;
	}
	
}
