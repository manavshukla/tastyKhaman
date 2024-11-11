package com.aone.module.city.service.impl;

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
import com.aone.module.city.dao.ICityDao;
import com.aone.module.city.model.City;
import com.aone.module.city.model.CityInitData;
import com.aone.module.city.service.ICityService;
import com.aone.module.state.model.State;
import com.aone.module.state.service.IStateService;

@Lazy
@Service("cityServiceImpl")
public class CityServiceImpl extends AbstractBaseMasterService<City, Long, ICityDao> implements ICityService {

	private ICityDao cityDao;

	private IStateService stateService;
	
	public IStateService getStateService() {
		return stateService;
	}

	@Autowired        
	@Qualifier(value="stateServiceImpl")
	public void setStateService(IStateService stateService) {
		this.stateService = stateService;
	}
	
	
	@Override
	public ICityDao getRepository() {
		return getCityDao();
	}

	public ICityDao getCityDao() {
		return cityDao;
	}

	@Autowired
	@Qualifier(value = "cityDaoImpl")
	public void setCityDao(ICityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public ResponseEntity<IResponseData<Boolean>> checkCityName(RequestData<City, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository()
				.checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId())
				.isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@Override
	public ResultCodeConstant validateData(City city) {
		if (city == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}

		// validate name
		if (city.getName() == null || city.getName().isEmpty()) {
			return ResultCodeConstant.COUNTRY_NAME_NOT_FOUND;
		}
		// check if already exist
		if (!getRepository().checkUniqueDataByField("name", city.getName(), "id", city.getId()).isEmpty()) {
			return ResultCodeConstant.COUNTRY_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public ResponseEntity<IResponseData<City>> getById(RequestData<City, Long> requestData) {
		ResponseEntity<IResponseData<City>> responseEntity = super.getById(requestData);
		IResponseData<City> responseData = responseEntity.getBody();

		if (responseData.getResponseCode() != ResultCodeConstant.SUCCESS.getResultCode()) {
			return responseEntity;
		}
		City city = responseData.getData();
		
		SearchData<State> searchData=new SearchData<>();
		List<State> stateList=stateService.getActiveData(searchData);
		
		CityInitData cityInitData = new CityInitData();
		cityInitData.setStateList(stateList);
		
		city.setCityInitData(cityInitData);
		
		return responseEntity;
	}
	
	@Override
	public List<City> getByStateId(long stateId){
		SearchData<City> searchData = new SearchData<>();
		City city = new City();
		city.setStateId(stateId);
		searchData.setData(city);
		return this.getActiveData(searchData);
	}
	
}