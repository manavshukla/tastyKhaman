package com.aone.module.contactWiseItemRate.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.contactWiseItemRate.dao.IContactWiseItemRateDao;
import com.aone.module.contactWiseItemRate.model.ContactWiseItemRate;

@Lazy
@Repository("contactWiseItemRateDaoImpl")
public class ContactWiseItemRateDaoImpl extends AbstractBaseMasterRepository<ContactWiseItemRate , Long> implements IContactWiseItemRateDao {

	@Override
	public Class<ContactWiseItemRate> getClazz() {
		return ContactWiseItemRate.class;
	}

}
