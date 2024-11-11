package com.aone.module.contactvehicle.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.contactvehicle.controller.IContactVehicleController;
import com.aone.module.contactvehicle.model.ContactVehicle;
import com.aone.module.contactvehicle.service.IContactVehicleService;

@RestController
@RequestMapping("/rest/contactVehicle")
public class ContactVehicleRestController extends AbstractBaseMasterRestController<ContactVehicle, Long, IContactVehicleService> implements IContactVehicleController{

	IContactVehicleService contactVehicleService;
	
	@Override
	public IContactVehicleService getService() {
		return getContactVehicleService();
	}

	public IContactVehicleService getContactVehicleService() {
		return contactVehicleService;
	}

	@Autowired
	@Qualifier(value="contactVehicleServiceImpl")
	public void setContactVehicleService(IContactVehicleService contactVehicleService) {
		this.contactVehicleService = contactVehicleService;
	}

	
}
