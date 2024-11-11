package com.aone.module.contactvehicle.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.contactvehicle.dao.IContactVehicleDao;
import com.aone.module.contactvehicle.model.ContactVehicle;
import com.aone.module.contactvehicle.service.IContactVehicleService;

@Lazy
@Service("contactVehicleServiceImpl")
public class ContactVehicleServiceImpl extends AbstractBaseMasterService<ContactVehicle, Long, IContactVehicleDao> implements IContactVehicleService {

	private IContactVehicleDao contactVehicleDao;
	
	@Override
	public IContactVehicleDao getRepository() {
		return getContactVehicleDao();
	}

	public IContactVehicleDao getContactVehicleDao() {
		return contactVehicleDao;
	}

	@Autowired
	@Qualifier(value = "contactVehicleDaoImpl")
	public void setContactVehicleDao(IContactVehicleDao contactVehicleDao) {
		this.contactVehicleDao = contactVehicleDao;
	}
	
	@Override
	public ResultCodeConstant validateData(ContactVehicle contactVehicle) {
		if(contactVehicle == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		if(contactVehicle.getAMCRegistrationDate() == null || contactVehicle.getAMCRegistrationDate().toString().isEmpty()) {
			return ResultCodeConstant.CONTACT_VEHICLE_AMC_REGISTRATION_DATE;
		}
		if(contactVehicle.getBrandName() == null || contactVehicle.getBrandName().isEmpty()) {
			return ResultCodeConstant.CONTACT_VEHICLE_BRAND_NAME;
		}
		if(contactVehicle.getModelNo() == null || contactVehicle.getModelNo().isEmpty()) {
			return ResultCodeConstant.CONTACT_VEHICLE_MODEL_NO;
		}
		if(contactVehicle.getRegistrationNo() == null || contactVehicle.getRegistrationNo().isEmpty()) {
			return ResultCodeConstant.CONTACT_VEHICLE_REGISTRATION_NO;
		}
		if(contactVehicle.getYearOfManufacture() == null || contactVehicle.getYearOfManufacture().isEmpty()) {
			return ResultCodeConstant.CONTACT_VEHICLE_YEAR_OF_MANUFACTURE;
		}
		if(contactVehicle.getContactId() <= 0) {
			return ResultCodeConstant.CONTACT_VEHICLE_CONTACT_ID;
		}
		return ResultCodeConstant.SUCCESS;
	}
}