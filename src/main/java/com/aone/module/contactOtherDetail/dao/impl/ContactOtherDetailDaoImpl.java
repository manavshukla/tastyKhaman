package com.aone.module.contactOtherDetail.dao.impl;


import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.contactOtherDetail.dao.IContactOtherDetailDao;
import com.aone.module.contactOtherDetail.model.ContactOtherDetail;

@Lazy
@Repository("contactOtherDetailDaoImpl")
public class ContactOtherDetailDaoImpl extends AbstractBaseMasterRepository<ContactOtherDetail   , Long> implements IContactOtherDetailDao   {

	@Override
	public Class<ContactOtherDetail> getClazz() {
		return ContactOtherDetail.class;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ContactOtherDetail> getOtherDetailByContactId(long contactId) {
		return super.getByFieldName("contactId", contactId);
	}
}
