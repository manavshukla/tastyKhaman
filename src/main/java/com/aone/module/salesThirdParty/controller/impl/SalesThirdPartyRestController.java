package com.aone.module.salesThirdParty.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.salesThirdParty.controller.ISalesThirdPartyController;
import com.aone.module.salesThirdParty.model.SalesThirdParty;
import com.aone.module.salesThirdParty.service.ISalesThirdPartyService;

@RestController
@RequestMapping("/rest/salesThirdParty")
public class SalesThirdPartyRestController extends AbstractBaseMasterRestController<SalesThirdParty  , Long, ISalesThirdPartyService> implements ISalesThirdPartyController {
	
	private ISalesThirdPartyService salesThirdPartyService;
	
	@Override
	public ISalesThirdPartyService getService() {
		return getSalesThirdPartyService();
	}

	public ISalesThirdPartyService getSalesThirdPartyService() {
		return salesThirdPartyService;
	}

	@Autowired        
	@Qualifier(value="salesThirdPartyServiceImpl")
	public void setSalesThirdPartyService(ISalesThirdPartyService salesThirdPartyService) {
		this.salesThirdPartyService = salesThirdPartyService;
	}
}
