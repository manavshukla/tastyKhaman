package com.aone.module.currency.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.currency.dao.ICurrencyDao;
import com.aone.module.currency.model.Currency;

@Lazy
@Repository("currencyDaoImpl")
public class CurrencyDaoImpl extends AbstractBaseMasterRepository<Currency, Long> implements ICurrencyDao {

	@Override
	public Class<Currency> getClazz() {
		return Currency.class;
	}

}
