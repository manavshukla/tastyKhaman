package com.aone.module.address.util;

import org.apache.commons.lang3.StringUtils;

import com.aone.module.address.model.Address;
import com.aone.module.city.model.City;
import com.aone.module.city.service.ICityService;
import com.aone.module.country.model.Country;
import com.aone.module.country.service.ICountryService;
import com.aone.module.state.model.State;
import com.aone.module.state.service.IStateService;

public class AddressUtil {
	
	public static String getFullAddress(Address address, ICityService cityService, IStateService stateService, ICountryService countryService) {
		
		if(address == null) {
			return StringUtils.EMPTY;
		}
		StringBuilder builder = new StringBuilder();
		
		if(address.getStreet() != null) {
			builder.append(address.getStreet());
		}
		
		if(cityService != null && address.getCityId() > 0) {
			City city = cityService.getById(address.getCityId()); 
			if(city != null) {
				builder.append(",").append(city.getName());
			}
		}
		
		if(stateService != null && address.getStateId() > 0) {
			State state = stateService.getById(address.getStateId()); 
			if(state != null) {
				builder.append(",").append(state.getName());
			}
		}
		
		if(countryService != null && address.getCountryId() > 0) {
			Country country = countryService.getById(address.getCountryId()); 
			if(country != null) {
				builder.append(",").append(country.getName());
			}
		}
		
		if(address.getZipCode() > 0) {
			builder.append("-").append(address.getZipCode());
		}
		
		return builder.toString();
	}
	
	private AddressUtil() {
		throw new IllegalStateException("Util class");
	}

}
