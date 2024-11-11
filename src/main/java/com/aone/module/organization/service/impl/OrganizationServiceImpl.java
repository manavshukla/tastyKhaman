package com.aone.module.organization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.organization.dao.IOrganizationDao;
import com.aone.module.organization.model.Organization;
import com.aone.module.organization.service.IOrganizationService;

@Lazy
@Service("organizationServiceImpl")
public class OrganizationServiceImpl extends AbstractBaseMasterService<Organization, Long, IOrganizationDao> implements
		IOrganizationService {
	
	private IOrganizationDao organizationDao;

	@Override
	public IOrganizationDao getRepository() {
		return getOrganizationDao();
	}

	public IOrganizationDao getOrganizationDao() {
		return organizationDao;
	}

	@Autowired
	@Qualifier(value = "organizationDaoImpl")
	public void setOrganizationDao(IOrganizationDao organizationDao) {
		this.organizationDao = organizationDao;
	}
}
