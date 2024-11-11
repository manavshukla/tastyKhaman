package com.aone.module.contactPerson.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.contactPerson.dao.IContactPersonDao;
import com.aone.module.contactPerson.model.ContactPerson;

@Lazy
@Repository("contactPersonDaoImpl")
public class ContactPersonDaoImpl extends AbstractBaseMasterRepository<ContactPerson, Long> implements IContactPersonDao {

	@Override
	public Class<ContactPerson> getClazz() {
		return ContactPerson.class;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ContactPerson> getContactPersonsByContactId(long contactId) {
		return super.getByFieldName("contactId", contactId);
	}

}
