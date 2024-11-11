package com.aone.module.address.service;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.address.model.Address;

public interface IAddressService  extends IBaseMasterService<Address  , Long>{

	public Address getAddressByForeignKeyId(Address address);
}
