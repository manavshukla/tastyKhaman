package com.aone.module.salesDriverDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.salesDriverDetails.controller.ISaleDriverDetailsController;
import com.aone.module.salesDriverDetails.model.SaleDriverDetails;
import com.aone.module.salesDriverDetails.service.ISaleDriverDetailsService;

@RestController
@RequestMapping("/rest/saleDriverDetails")
public class SaleDriverDetailsRestController extends AbstractBaseMasterRestController<SaleDriverDetails  , Long, ISaleDriverDetailsService> implements ISaleDriverDetailsController {
	
	private ISaleDriverDetailsService saleDriverDetailsService;
	
	@Override
	public ISaleDriverDetailsService getService() {
		return getSaleDriverDetailsService();
	}

	public ISaleDriverDetailsService getSaleDriverDetailsService() {
		return saleDriverDetailsService;
	}

	@Autowired        
	@Qualifier(value="saleDriverDetailsServiceImpl")
	public void setSaleDriverDetailsService(ISaleDriverDetailsService saleDriverDetailsService) {
		this.saleDriverDetailsService = saleDriverDetailsService;
	}
}
