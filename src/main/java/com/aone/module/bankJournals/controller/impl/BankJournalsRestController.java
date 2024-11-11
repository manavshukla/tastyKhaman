package com.aone.module.bankJournals.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.bankJournals.controller.IBankJournalsController;
import com.aone.module.bankJournals.model.BankJournals;
import com.aone.module.bankJournals.service.IBankJournalsService;

@RestController
@RequestMapping("/rest/bankjournals")
public class BankJournalsRestController extends AbstractBaseMasterRestController<BankJournals, Long, IBankJournalsService> implements IBankJournalsController {

	private IBankJournalsService bankJournalsService;
	
	@Override
	public IBankJournalsService getService() {
		return getBankJournalsService();
	}

	public IBankJournalsService getBankJournalsService() {
		return bankJournalsService;
	}

	@Autowired
	@Qualifier(value="bankJournalsServiceImpl")
	public void setBankJournalsService(IBankJournalsService bankJournalsService) {
		this.bankJournalsService = bankJournalsService;
	}


}
