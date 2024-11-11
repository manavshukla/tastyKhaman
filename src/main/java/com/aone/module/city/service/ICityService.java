package com.aone.module.city.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.city.model.City;

public interface ICityService  extends IBaseMasterService<City, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkCityName(RequestData<City, Long> requestData);
	public List<City> getByStateId(long stateId);
}
