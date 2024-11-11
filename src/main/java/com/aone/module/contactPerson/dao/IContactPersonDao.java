package com.aone.module.contactPerson.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.contactPerson.model.ContactPerson;

public interface IContactPersonDao extends IBaseMasterRepository<ContactPerson, Long>{
	
	public List<ContactPerson> getContactPersonsByContactId(long contactId);

}
