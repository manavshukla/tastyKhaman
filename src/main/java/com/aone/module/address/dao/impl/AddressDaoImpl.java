package com.aone.module.address.dao.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.address.dao.IAddressDao;
import com.aone.module.address.model.Address;

@Lazy
@Repository("addressDaoImpl")
public class AddressDaoImpl extends AbstractBaseMasterRepository<Address  , Long> implements IAddressDao   {

	@Override
	public Class<Address> getClazz() {
		return Address.class;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Address> getAddressByContact(Address address) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("foreinKey", address.getForeinKey());
		params.put("deleted", false);
		params.put("moduleName", address.getModuleName());
		return super.getByQueryData(params, Collections.emptyMap());
	}

}
