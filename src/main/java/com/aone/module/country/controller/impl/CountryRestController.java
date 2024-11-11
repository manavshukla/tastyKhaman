package com.aone.module.country.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.country.controller.ICountryController;
import com.aone.module.country.model.Country;
import com.aone.module.country.service.ICountryService;

@RestController
@RequestMapping("/rest/country")
@SecurityClassRole(baseRoleName = SecurityRoleModule.COUNTRY)
public class CountryRestController extends AbstractBaseMasterRestController<Country, Long, ICountryService> implements ICountryController {
	
	private ICountryService countryService;
	
	@Override
	public ICountryService getService() {
		return getCountryService();
	}

	public ICountryService getCountryService() {
		return countryService;
	}

	@Autowired
	@Qualifier(value="countryServiceImpl")
	public void setCountryService(ICountryService countryService) {
		this.countryService = countryService;
	}
	
	@Override
	@RequestMapping(value="/checkCountryName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkCountryName(@RequestBody RequestData<Country,Long> requestData) {
		return getService().checkCountryName(requestData);
	}
}
