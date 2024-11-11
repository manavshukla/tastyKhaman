package com.aone.module.state.service.impl;

import java.util.List;

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
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.country.model.Country;
import com.aone.module.country.service.ICountryService;
import com.aone.module.state.dao.IStateDao;
import com.aone.module.state.model.State;
import com.aone.module.state.model.StateInitData;
import com.aone.module.state.service.IStateService;

@Lazy
@Service("stateServiceImpl")
public class StateServiceImpl extends AbstractBaseMasterService<State, Long, IStateDao> implements
		IStateService {
	
	private IStateDao stateDao;
	private ICountryService countryService;
	
	public ICountryService getCountryService() {
		return countryService;
	}

	@Autowired
	@Qualifier(value="countryServiceImpl")
	public void setCountryService(ICountryService countryService) {
		this.countryService = countryService;
	}

	@Override
	public IStateDao getRepository() {
		return getStateDao();
	}

	public IStateDao getStateDao() {
		return stateDao;
	}

	@Autowired
	@Qualifier(value = "stateDaoImpl")
	public void setStateDao(IStateDao stateDao) {
		this.stateDao = stateDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkStateName(RequestData<State, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkStateCode(RequestData<State, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("code", requestData.getData().getCode(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(State state) {
		if(state == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(state.getName() == null || state.getName().isEmpty()) {
			return ResultCodeConstant.STATE_NAME_NOT_FOUND;
		}
		
		if(state.getCode() <= 0) {
			return ResultCodeConstant.STATE_CODE_GT_ZERO;
		}
		
		// check if category name already exist
		if(!getRepository().checkUniqueDataByField("name", state.getName(), "id", state.getId()).isEmpty()) {
			return ResultCodeConstant.STATE_NAME_ALREADY_EXIST;
		}
		
		// check if category name already exist
		if(!getRepository().checkUniqueDataByField("code", state.getCode(), "id", state.getId()).isEmpty()) {
			return ResultCodeConstant.STATE_CODE_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<State>> getById(RequestData<State, Long> requestData) {
		ResponseEntity<IResponseData<State>> responseEntity = super.getById(requestData);
		IResponseData<State> responseData = responseEntity.getBody();
		
		if(responseData.getResponseCode() != ResultCodeConstant.SUCCESS.getResultCode()) {
			return responseEntity;
		}
		
		State state = responseData.getData();
		
		// fecth country list
		SearchData<Country> searchData = new SearchData<>();
		List<Country> countryList = countryService.getActiveData(searchData);
		
		StateInitData stateInitData = new StateInitData();
		stateInitData.setCountryList(countryList);

		state.setStateInitData(stateInitData);
		return responseEntity;
	}

	@Override
	public List<State> getByCountryId(long countryId){
		SearchData<State> searchData = new SearchData<>();
		State state = new State();
		state.setCountryId(countryId);
		searchData.setData(state);
		return this.getActiveData(searchData);
	}


}