package com.aone.module.country.controller;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.country.model.Country;

public interface ICountryController extends IBaseMasterController<Country, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkCountryName(RequestData<Country,Long> requestData);
}
