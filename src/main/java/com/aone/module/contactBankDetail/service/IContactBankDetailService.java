package com.aone.module.contactBankDetail.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.contactBankDetail.model.ContactBankDetail;

public interface IContactBankDetailService  extends IBaseMasterService<ContactBankDetail  , Long>{

	public List<ContactBankDetail> getContactBankDetailByContactId(long contactId);
}
