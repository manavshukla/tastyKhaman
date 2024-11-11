package com.aone.module.saleorderservices.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.saleorderservices.controller.ISaleOrderServicesController;
import com.aone.module.saleorderservices.model.SaleOrderServices;
import com.aone.module.saleorderservices.service.ISaleOrderServicesService;

@RestController
@RequestMapping("/rest/saleorderservices")

public class SaleOrderServicesRestController extends AbstractBaseMasterRestController<SaleOrderServices, Long, ISaleOrderServicesService> implements ISaleOrderServicesController{

	ISaleOrderServicesService saleOrderSerivcesService;
	@Override
	public ISaleOrderServicesService getService() {
		return getSaleOrderSerivce();
	}
	public ISaleOrderServicesService getSaleOrderSerivce() {
		return saleOrderSerivcesService;
	}
	
	@Autowired        
	@Qualifier(value="saleOrderServicesServiceImpl")
	public void setSaleOrderSerivce(ISaleOrderServicesService saleOrderSerivcesService) {
		this.saleOrderSerivcesService = saleOrderSerivcesService;
	}

}
