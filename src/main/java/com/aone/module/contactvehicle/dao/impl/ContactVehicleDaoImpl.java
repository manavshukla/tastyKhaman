package com.aone.module.contactvehicle.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.contactvehicle.dao.IContactVehicleDao;
import com.aone.module.contactvehicle.model.ContactVehicle;

@Lazy
@Repository("contactVehicleDaoImpl")
public class ContactVehicleDaoImpl extends AbstractBaseMasterRepository<ContactVehicle, Long> implements IContactVehicleDao{

	@Override
	public Class<ContactVehicle> getClazz() {
		return ContactVehicle.class;
	}

}
