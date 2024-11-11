package com.aone.module.organizationPaymentTerms.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.organizationPaymentTerms.dao.IOrganizationPaymentTermsDao;
import com.aone.module.organizationPaymentTerms.model.OrganizationPaymentTerms;

@Lazy
@Repository("organizationPaymentTermsDaoImpl")
public class OrganizationPaymentTermsDaoImpl extends AbstractBaseMasterRepository<OrganizationPaymentTerms , Long> implements IOrganizationPaymentTermsDao  {

	@Override
	public Class<OrganizationPaymentTerms> getClazz() {
		return OrganizationPaymentTerms.class;
	}
}
