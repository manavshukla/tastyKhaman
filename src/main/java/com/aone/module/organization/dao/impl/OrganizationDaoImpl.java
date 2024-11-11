package com.aone.module.organization.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.organization.dao.IOrganizationDao;
import com.aone.module.organization.model.Organization;

@Lazy
@Repository("organizationDaoImpl")
public class OrganizationDaoImpl extends AbstractBaseMasterRepository<Organization, Long> implements IOrganizationDao {

	@Override
	public Class<Organization> getClazz() {
		return Organization.class;
	}

}
