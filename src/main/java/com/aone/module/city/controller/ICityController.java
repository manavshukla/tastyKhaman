package com.aone.module.city.controller;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.city.model.City;

public interface ICityController extends IBaseMasterController<City, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkCityName(RequestData<City,Long> requestData);
}
