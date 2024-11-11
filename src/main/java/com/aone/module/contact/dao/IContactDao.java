package com.aone.module.contact.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.contact.model.Contact;

public interface IContactDao extends IBaseMasterRepository<Contact, Long>{
	public List<Contact> getListByCategory(long categoryId);
}
