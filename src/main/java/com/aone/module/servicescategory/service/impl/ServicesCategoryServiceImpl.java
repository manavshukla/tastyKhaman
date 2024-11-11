package com.aone.module.servicescategory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.servicescategory.dao.IServicesCategoryDao;
import com.aone.module.servicescategory.model.ServicesCategory;
import com.aone.module.servicescategory.service.IServicesCategoryService;

@Lazy
@Service("servicesCategoryServiceImpl")
public class ServicesCategoryServiceImpl extends AbstractBaseMasterService<ServicesCategory, Long, IServicesCategoryDao> implements IServicesCategoryService {

	private IServicesCategoryDao servicesCategoryDao;
	
	@Override
	public IServicesCategoryDao getRepository() {
		return getServicesCategoryDao();
	}

	public IServicesCategoryDao getServicesCategoryDao() {
		return servicesCategoryDao;
	}

	@Autowired
	@Qualifier(value = "servicesCategoryDaoImpl")
	public void setServicesDao(IServicesCategoryDao servicesCategoryDao) {
		this.servicesCategoryDao = servicesCategoryDao;
	}
	
	
	public ResultCodeConstant validateData(ServicesCategory serviceCategory) {
		if(serviceCategory == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		if(serviceCategory.getDescription() == null || serviceCategory.getDescription().isEmpty()) {
			return ResultCodeConstant.SERVICE_CATEGORY_DESCRIPTION;
		}
		
		if(serviceCategory.getName() == null || serviceCategory.getName().isEmpty()) {
			return ResultCodeConstant.SERVICE_CATEGORY_NAME;
		}
		
		if(serviceCategory.getParentCategoryId() <= 0) {
			return ResultCodeConstant.SERVICE_CATEGORY_PARENT_CATEGORY_ID;
		}

		return ResultCodeConstant.SUCCESS;
	}
}