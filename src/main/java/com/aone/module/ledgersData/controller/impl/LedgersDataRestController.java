package com.aone.module.ledgersData.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.ledgersData.controller.ILedgersDataController;
import com.aone.module.ledgersData.model.LedgersData;
import com.aone.module.ledgersData.service.ILedgersDataService;

@RestController
@RequestMapping("/rest/ledgersData")
public class LedgersDataRestController extends AbstractBaseMasterRestController<LedgersData, Long, ILedgersDataService> implements ILedgersDataController {
	
	private ILedgersDataService ledgersDataService;
	
	@Override
	public ILedgersDataService getService() {
		return getLedgersDataService();
	}

	public ILedgersDataService getLedgersDataService() {
		return ledgersDataService;
	}

	@Autowired        
	@Qualifier(value="ledgersDataServiceImpl")
	public void setLedgersDataService(ILedgersDataService ledgersDataService) {
		this.ledgersDataService = ledgersDataService;
	}
	
}
