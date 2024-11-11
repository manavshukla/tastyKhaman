package com.aone.module.salesDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.salesDetails.controller.ISalesDetailsController;
import com.aone.module.salesDetails.model.SalesDetails;
import com.aone.module.salesDetails.service.ISalesDetailsService;

@RestController
@RequestMapping("/rest/salesDetails")
public class SalesDetailsRestController extends AbstractBaseMasterRestController<SalesDetails  , Long, ISalesDetailsService> implements ISalesDetailsController {
	
	private ISalesDetailsService salesDetailsService;
	
	@Override
	public ISalesDetailsService getService() {
		return getSalesDetailsService();
	}

	public ISalesDetailsService getSalesDetailsService() {
		return salesDetailsService;
	}

	@Autowired        
	@Qualifier(value="salesDetailsServiceImpl")
	public void setSalesDetailsService(ISalesDetailsService salesDetailsService) {
		this.salesDetailsService = salesDetailsService;
	}
}
