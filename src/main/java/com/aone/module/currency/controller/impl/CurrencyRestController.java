package com.aone.module.currency.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.currency.controller.ICurrencyController;
import com.aone.module.currency.model.Currency;
import com.aone.module.currency.service.ICurrencyService;

@RestController
@RequestMapping("/rest/currency")
public class CurrencyRestController extends AbstractBaseMasterRestController<Currency, Long, ICurrencyService> implements ICurrencyController {
	
	private ICurrencyService currencyService;
	
	@Override
	public ICurrencyService getService() {
		return getCurrencyService();
	}

	public ICurrencyService getCurrencyService() {
		return currencyService;
	}

	@Autowired        
	@Qualifier(value="currencyServiceImpl")
	public void setCurrencyService(ICurrencyService currencyService) {
		this.currencyService = currencyService;
	}
	
}
