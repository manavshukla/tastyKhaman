package com.aone.module.address.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.address.dao.IAddressDao;
import com.aone.module.address.model.Address;
import com.aone.module.address.service.IAddressService;

@Lazy
@Service("addressServiceImpl")
public class AddressServiceImpl extends AbstractBaseMasterService<Address, Long, IAddressDao>
		implements IAddressService {

	private IAddressDao  addressDao;

	@Override
	public IAddressDao getRepository() {
		return getAddressDao();
	}

	public IAddressDao getAddressDao() {
		return addressDao;
	}

	@Autowired
	@Qualifier(value = "addressDaoImpl")
	public void setAddressDao(IAddressDao addressDao) {
		this.addressDao = addressDao;
	}
	
	@Override
	public ResultCodeConstant validateData(Address address) {
		if (address == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}

		if (address.getCountryId() < 0) {
			return ResultCodeConstant.ADDRESS_COUNTRY_CODE_NOT_FOUND;
		}
		if (address.getStateId() < 0) {
			return ResultCodeConstant.ADDRESS_STATE_CODE_NOT_FOUND;
		}
		if (address.getCityId() < 0) {
			return ResultCodeConstant.ADDRESS_CITY_CODE_NOT_FOUND;
		}
		if (address.getForeinKey() <= 0) {
			return ResultCodeConstant.ADDRESS_FOREIGN_KEY_NOT_FOUND;
		}
		if (address.getModuleName() == null || address.getModuleName().isEmpty()) {
			return ResultCodeConstant.ADDRESS_MOUDLE_NAME_NOT_FOUND;
		}
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public Address getAddressByForeignKeyId(Address address) {
		Map<String, Object> params = new HashMap<>();
		params.put("foreinKey", address.getForeinKey());
		params.put("moduleName", address.getModuleName());
		params.put("deleted", false);
		List<Address> addressList = getRepository().getByQueryData(params, Collections.emptyMap());
		if(addressList == null || addressList.isEmpty()) {
			return null;
		}
		return addressList.get(0);
	}

}
