package com.aone.module.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.services.dao.IServicesDao;
import com.aone.module.services.model.Services;
import com.aone.module.services.service.IServicesService;

@Lazy
@Service("servicesServiceImpl")
public class ServicesServiceImpl extends AbstractBaseMasterService<Services, Long, IServicesDao> implements IServicesService {

	private IServicesDao servicesDao;
	
	@Override
	public IServicesDao getRepository() {
		return getServicesDao();
	}

	public IServicesDao getServicesDao() {
		return servicesDao;
	}

	@Autowired
	@Qualifier(value = "servicesDaoImpl")
	public void setServicesDao(IServicesDao servicesDao) {
		this.servicesDao = servicesDao;
	}
	
	
	public ResultCodeConstant validateData(Services service) {
		if(service == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		// validate
		
		if(service.getParentServiceCategoryId() == 0) {
			return ResultCodeConstant.SERVICE_CATEGORY_ID;
		}
		
		if(service.getPrice() == 0) {
			return ResultCodeConstant.SERVICE_PRICE;
		}
		if(service.getName() == null || service.getName().isEmpty()) {
			return ResultCodeConstant.SERVICE_NAME;
		}
		if(service.getDuration()== null || service.getDuration().isEmpty()) {
			return ResultCodeConstant.SERVICE_DURATION;
		}
		return ResultCodeConstant.SUCCESS;
	}
}