package com.aone.module.cashJournals.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.cashJournals.controller.ICashJournalsController;
import com.aone.module.cashJournals.model.CashJournals;
import com.aone.module.cashJournals.service.ICashJournalsService;

@RestController
@RequestMapping("/rest/cashJournals")
public class CashJournalsRestController extends AbstractBaseMasterRestController<CashJournals, Long, ICashJournalsService> implements ICashJournalsController {
	
	private ICashJournalsService cashJournalsService;
	
	@Override
	public ICashJournalsService getService() {
		return getCashJournalsService();
	}

	public ICashJournalsService getCashJournalsService() {
		return cashJournalsService;
	}

	@Autowired        
	@Qualifier(value="cashJournalsServiceImpl")
	public void setCashJournalsService(ICashJournalsService cashJournalsService) {
		this.cashJournalsService = cashJournalsService;
	}
}
