package com.aone.module.country.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.country.dao.ICountryDao;
import com.aone.module.country.model.Country;

@Lazy
@Repository("countryDaoImpl")
public class CountryDaoImpl extends AbstractBaseMasterRepository<Country, Long> implements ICountryDao {

	@Override
	public Class<Country> getClazz() {
		return Country.class;
	}

}
