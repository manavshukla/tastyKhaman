package com.aone.module.organizationPaymentTerms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.organizationPaymentTerms.dao.IOrganizationPaymentTermsDao;
import com.aone.module.organizationPaymentTerms.model.OrganizationPaymentTerms;
import com.aone.module.organizationPaymentTerms.service.IOrganizationPaymentTermsService;

@Lazy
@Service("organizationPaymentTermsServiceImpl")
public class OrganizationPaymentTermsServiceImpl extends AbstractBaseMasterService<OrganizationPaymentTerms , Long, IOrganizationPaymentTermsDao  >
		implements IOrganizationPaymentTermsService {

	private IOrganizationPaymentTermsDao  organizationPaymentTermsDao;

	@Override
	public IOrganizationPaymentTermsDao getRepository() {
		return getOrganizationPaymentTermsDao();
	}

	public IOrganizationPaymentTermsDao getOrganizationPaymentTermsDao() {
		return organizationPaymentTermsDao;
	}

	@Autowired
	@Qualifier(value = "organizationPaymentTermsDaoImpl")
	public void setOrganizationPaymentTermsDao(
			IOrganizationPaymentTermsDao organizationPaymentTermsDao) {
		this.organizationPaymentTermsDao = organizationPaymentTermsDao;
	}
}
