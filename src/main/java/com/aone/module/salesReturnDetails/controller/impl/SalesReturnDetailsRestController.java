package com.aone.module.salesReturnDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.salesReturnDetails.controller.ISalesReturnDetailsController;
import com.aone.module.salesReturnDetails.model.SalesReturnDetails;
import com.aone.module.salesReturnDetails.service.ISalesReturnDetailsService;

@RestController
@RequestMapping("/rest/salesReturnDetails")
public class SalesReturnDetailsRestController extends AbstractBaseMasterRestController<SalesReturnDetails , Long, ISalesReturnDetailsService> implements ISalesReturnDetailsController {
	
	private ISalesReturnDetailsService salesReturnDetailsService;
	
	@Override
	public ISalesReturnDetailsService getService() {
		return getSalesReturnDetailsService();
	}

	public ISalesReturnDetailsService getSalesReturnDetailsService() {
		return salesReturnDetailsService;
	}

	@Autowired        
	@Qualifier(value="salesReturnDetailsServiceImpl")
	public void setSalesReturnDetailsService(ISalesReturnDetailsService salesReturnDetailsService) {
		this.salesReturnDetailsService = salesReturnDetailsService;
	}
}
