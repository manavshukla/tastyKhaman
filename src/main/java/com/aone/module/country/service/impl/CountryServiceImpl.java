package com.aone.module.country.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.country.dao.ICountryDao;
import com.aone.module.country.model.Country;
import com.aone.module.country.service.ICountryService;

@Lazy
@Service("countryServiceImpl")
public class CountryServiceImpl extends AbstractBaseMasterService<Country, Long, ICountryDao> implements
		ICountryService {
	
	private ICountryDao countryDao;

	@Override
	public ICountryDao getRepository() {
		return getCountryDao();
	}

	public ICountryDao getCountryDao() {
		return countryDao;
	}

	@Autowired
	@Qualifier(value = "countryDaoImpl")
	public void setCountryDao(ICountryDao countryDao) {
		this.countryDao = countryDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkCountryName(RequestData<Country, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(Country country) {
		if(country == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(country.getName() == null || country.getName().isEmpty()) {
			return ResultCodeConstant.COUNTRY_NAME_NOT_FOUND;
		}
		// check if already exist
		if(!getRepository().checkUniqueDataByField("name", country.getName(), "id", country.getId()).isEmpty()) {
			return ResultCodeConstant.COUNTRY_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}
}
