package com.aone.module.address.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.address.controller.IAddressController;
import com.aone.module.address.model.Address;
import com.aone.module.address.service.IAddressService;

@RestController
@RequestMapping("/rest/address")
public class AddressRestController extends AbstractBaseMasterRestController<Address , Long, IAddressService > implements IAddressController  {

	private IAddressService addressService;
	
	@Override
	public IAddressService getService() {
		return getAddressService();
	}

	public IAddressService getAddressService() {
		return addressService;
	}

	@Autowired
	@Qualifier(value="addressServiceImpl")
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}

}
