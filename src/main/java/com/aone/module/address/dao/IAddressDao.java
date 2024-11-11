package com.aone.module.address.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.address.model.Address;

public interface IAddressDao extends IBaseMasterRepository<Address , Long>{

	public List<Address> getAddressByContact(Address address);

}
