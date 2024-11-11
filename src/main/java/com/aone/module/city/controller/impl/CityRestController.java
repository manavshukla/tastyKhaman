package com.aone.module.city.controller.impl;

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
import com.aone.module.city.controller.ICityController;
import com.aone.module.city.model.City;
import com.aone.module.city.service.ICityService;

@RestController
@RequestMapping("/rest/city")
@SecurityClassRole(baseRoleName = SecurityRoleModule.CITY)
public class CityRestController extends AbstractBaseMasterRestController<City, Long, ICityService> implements ICityController {
	
	private ICityService cityService;
	
	@Override
	public ICityService getService() {
		return getCityService();
	}

	public ICityService getCityService() {
		return cityService;
	}

	@Autowired        
	@Qualifier(value="cityServiceImpl")
	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@Override
	@RequestMapping(value="/checkCityName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkCityName(@RequestBody RequestData<City,Long> requestData) {
		return getService().checkCityName(requestData);
	}
	
	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<City>> getActiveData(@RequestBody RequestData<SearchData<City>, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getActiveData(requestData);
	}
}
