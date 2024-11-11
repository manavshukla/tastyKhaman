package com.aone.module.state.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.state.controller.IStateController;
import com.aone.module.state.model.State;
import com.aone.module.state.service.IStateService;

@RestController
@RequestMapping("/rest/state")
@SecurityClassRole(baseRoleName = SecurityRoleModule.STATE)
public class StateRestController extends AbstractBaseMasterRestController<State, Long, IStateService> implements IStateController {
	
	private IStateService stateService;
	
	@Override
	public IStateService getService() {
		return getStateService();
	}

	public IStateService getStateService() {
		return stateService;
	}

	@Autowired        
	@Qualifier(value="stateServiceImpl")
	public void setStateService(IStateService stateService) {
		this.stateService = stateService;
	}
	
	@Override
	@RequestMapping(value="/checkStateName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkStateName(@RequestBody RequestData<State,Long> requestData) {
		return getService().checkStateName(requestData);
	}
	
	@Override
	@RequestMapping(value="/checkStateCode", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkStateCode(@RequestBody RequestData<State,Long> requestData) {
		return getService().checkStateCode(requestData);
	}
	
	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<State>> getActiveData(@RequestBody RequestData<SearchData<State>, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getActiveData(requestData);
	}
}
