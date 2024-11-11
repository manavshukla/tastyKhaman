package com.aone.module.contactPerson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.contactPerson.dao.IContactPersonDao;
import com.aone.module.contactPerson.model.ContactPerson;
import com.aone.module.contactPerson.service.IContactPersonService;

@Lazy
@Service("contactPersonServiceImpl")
public class ContactPersonServiceImpl extends AbstractBaseMasterService<ContactPerson, Long, IContactPersonDao>
		implements IContactPersonService {

	private IContactPersonDao contactPersonDao;

	@Override
	public IContactPersonDao getRepository() {
		return getContactPersonDao();
	}

	public IContactPersonDao getContactPersonDao() {
		return contactPersonDao;
	}

	@Autowired
	@Qualifier(value = "contactPersonDaoImpl")
	public void setContactPersonDao(IContactPersonDao contactPersonDao) {
		this.contactPersonDao = contactPersonDao;
	}

	@Override
	public List<ContactPerson> getContactPersonsByContactId(long contactId) {
		return getRepository().getContactPersonsByContactId(contactId);
	}
	
}
