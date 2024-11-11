package com.aone.module.contactPayTerms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.contactPayTerms.dao.IContactPayTermsDao;
import com.aone.module.contactPayTerms.model.ContactPayTerms;
import com.aone.module.contactPayTerms.service.IContactPayTermsService;

@Lazy
@Service("contactPayTermsServiceImpl")
public class ContactPayTermsServiceImpl extends AbstractBaseMasterService<ContactPayTerms, Long, IContactPayTermsDao> implements
		IContactPayTermsService {
	
	private IContactPayTermsDao contactPayTermsDao;

	@Override
	public IContactPayTermsDao getRepository() {
		return getContactPayTermsDao();
	}

	public IContactPayTermsDao getContactPayTermsDao() {
		return contactPayTermsDao;
	}

	@Autowired
	@Qualifier(value = "contactPayTermsDaoImpl")
	public void setContactPayTermsDao(IContactPayTermsDao contactPayTermsDao) {
		this.contactPayTermsDao = contactPayTermsDao;
	}

}