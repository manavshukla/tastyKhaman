package com.aone.module.contactPayTerms.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.contactPayTerms.dao.IContactPayTermsDao;
import com.aone.module.contactPayTerms.model.ContactPayTerms;

@Lazy
@Repository("contactPayTermsDaoImpl")
public class ContactPayTermsDaoImpl extends AbstractBaseMasterRepository<ContactPayTerms, Long> implements IContactPayTermsDao {

	@Override
	public Class<ContactPayTerms> getClazz() {
		return ContactPayTerms.class;
	}

}
