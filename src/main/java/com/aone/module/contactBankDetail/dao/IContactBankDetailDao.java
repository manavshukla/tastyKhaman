package com.aone.module.contactBankDetail.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.contactBankDetail.model.ContactBankDetail;

public interface IContactBankDetailDao extends IBaseMasterRepository<ContactBankDetail  , Long>{

	public List<ContactBankDetail> getContactBankDetailByContactId(long contactId);
}
