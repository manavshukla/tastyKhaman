package com.aone.module.contactWiseItemRate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.contactWiseItemRate.dao.IContactWiseItemRateDao;
import com.aone.module.contactWiseItemRate.model.ContactWiseItemRate;
import com.aone.module.contactWiseItemRate.service.IContactWiseItemRateService;

@Lazy
@Service("contactWiseItemRateServiceImpl")
public class ContactWiseItemRateServiceImpl extends AbstractBaseMasterService<ContactWiseItemRate, Long, IContactWiseItemRateDao> implements
		IContactWiseItemRateService {
	
	private IContactWiseItemRateDao contactWiseItemRateDao;

	@Override
	public IContactWiseItemRateDao getRepository() {
		return getContactWiseItemRateDao();
	}

	public IContactWiseItemRateDao getContactWiseItemRateDao() {
		return contactWiseItemRateDao;
	}

	@Autowired
	@Qualifier(value = "contactWiseItemRateDaoImpl")
	public void setContactWiseItemRateDao(IContactWiseItemRateDao contactWiseItemRateDao) {
		this.contactWiseItemRateDao = contactWiseItemRateDao;
	}

}