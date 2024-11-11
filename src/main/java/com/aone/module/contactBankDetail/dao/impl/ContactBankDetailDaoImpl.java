package com.aone.module.contactBankDetail.dao.impl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.contactBankDetail.dao.IContactBankDetailDao;
import com.aone.module.contactBankDetail.model.ContactBankDetail;

@Lazy
@Repository("contactBankDetailDaoImpl")
public class ContactBankDetailDaoImpl extends AbstractBaseMasterRepository<ContactBankDetail, Long>
		implements IContactBankDetailDao {

	@Override
	public Class<ContactBankDetail> getClazz() {
		return ContactBankDetail.class;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ContactBankDetail> getContactBankDetailByContactId(long contactId) {
		return super.getByFieldName("contactId", contactId);
	}
}
