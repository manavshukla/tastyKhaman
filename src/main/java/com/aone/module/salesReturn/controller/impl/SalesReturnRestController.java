package com.aone.module.salesReturn.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.salesReturn.controller.ISalesReturnController;
import com.aone.module.salesReturn.model.SalesReturn;
import com.aone.module.salesReturn.service.ISalesReturnService;

@RestController
@RequestMapping("/rest/salesReturn")
public class SalesReturnRestController extends AbstractBaseMasterRestController<SalesReturn , Long, ISalesReturnService> implements ISalesReturnController {
	
	private ISalesReturnService salesReturnService;
	
	@Override
	public ISalesReturnService getService() {
		return getSalesReturnService();
	}

	public ISalesReturnService getSalesReturnService() {
		return salesReturnService;
	}

	@Autowired        
	@Qualifier(value="salesReturnServiceImpl")
	public void setSalesReturnService(ISalesReturnService salesReturnService) {
		this.salesReturnService = salesReturnService;
	}
}
