package com.aone.module.state.controller;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.state.model.State;

public interface IStateController extends IBaseMasterController<State, Long>{

	public ResponseEntity<IResponseData<Boolean>> checkStateName(RequestData<State,Long> requestData);
	
	public ResponseEntity<IResponseData<Boolean>> checkStateCode(RequestData<State, Long> requestData);
}
