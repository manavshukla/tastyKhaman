package com.aone.module.bomStockDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.bomStockDetails.controller.IBomStockDetailsController;
import com.aone.module.bomStockDetails.model.BomStockDetails;
import com.aone.module.bomStockDetails.service.IBomStockDetailsService;

@RestController
@RequestMapping("/rest/bomStockDetails")
public class BomStockDetailsRestController extends AbstractBaseMasterRestController<BomStockDetails   , Long, IBomStockDetailsService > implements IBomStockDetailsController  {

	private IBomStockDetailsService bomStockDetailsService;
	
	@Override
	public IBomStockDetailsService getService() {
		return getBomStockDetailsService();
	}

	public IBomStockDetailsService getBomStockDetailsService() {
		return bomStockDetailsService;
	}

	@Autowired
	@Qualifier(value="bomStockDetailsServiceImpl")
	public void setBomStockDetailsService(IBomStockDetailsService bomStockDetailsService) {
		this.bomStockDetailsService = bomStockDetailsService;
	}

}
