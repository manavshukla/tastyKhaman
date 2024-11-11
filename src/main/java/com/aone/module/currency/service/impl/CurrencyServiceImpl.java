package com.aone.module.currency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.currency.dao.ICurrencyDao;
import com.aone.module.currency.model.Currency;
import com.aone.module.currency.service.ICurrencyService;

@Lazy
@Service("currencyServiceImpl")
public class CurrencyServiceImpl extends AbstractBaseMasterService<Currency, Long, ICurrencyDao>
		implements ICurrencyService {

	private ICurrencyDao currencyDao;

	@Override
	public ICurrencyDao getRepository() {
		return getCurrencyDao();
	}

	public ICurrencyDao getCurrencyDao() {
		return currencyDao;
	}

	@Autowired
	@Qualifier(value = "currencyDaoImpl")
	public void setCurrencyDao(ICurrencyDao currencyDao) {
		this.currencyDao = currencyDao;
	}

}