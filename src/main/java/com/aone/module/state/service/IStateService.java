package com.aone.module.state.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.state.model.State;

public interface IStateService  extends IBaseMasterService<State, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkStateName(RequestData<State, Long> requestData);
	
	public ResponseEntity<IResponseData<Boolean>> checkStateCode(RequestData<State, Long> requestData);
	
	public List<State> getByCountryId(long countryId);
}
