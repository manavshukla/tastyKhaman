package com.aone.module.contactCategory.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.contactCategory.dao.IContactCategoryDao;
import com.aone.module.contactCategory.model.ContactCategory;

@Lazy
@Repository("contactCategoryDaoImpl")
public class ContactCategoryDaoImpl extends AbstractBaseMasterRepository<ContactCategory , Long> implements IContactCategoryDao {

	@Override
	public Class<ContactCategory> getClazz() {
		return ContactCategory.class;
	}

}
