package com.aone.module.country.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.country.model.Country;

public interface ICountryService  extends IBaseMasterService<Country, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkCountryName(RequestData<Country, Long> requestData);
}
