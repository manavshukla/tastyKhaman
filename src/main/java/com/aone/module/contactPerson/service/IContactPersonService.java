package com.aone.module.contactPerson.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.contactPerson.model.ContactPerson;

public interface IContactPersonService  extends IBaseMasterService<ContactPerson, Long>{

	public List<ContactPerson> getContactPersonsByContactId(long contactId);
	
}
