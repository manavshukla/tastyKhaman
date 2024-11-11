package com.aone.module.contactBankDetail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.contactBankDetail.dao.IContactBankDetailDao;
import com.aone.module.contactBankDetail.model.ContactBankDetail;
import com.aone.module.contactBankDetail.service.IContactBankDetailService;

@Lazy
@Service("contactBankDetailServiceImpl")
public class ContactBankDetailServiceImpl extends AbstractBaseMasterService<ContactBankDetail  , Long, IContactBankDetailDao   >
		implements IContactBankDetailService  {

	private IContactBankDetailDao  contactBankDetailDao;

	@Override
	public IContactBankDetailDao getRepository() {
		return getContactBankDetailDao();
	}

	public IContactBankDetailDao getContactBankDetailDao() {
		return contactBankDetailDao;
	}

	@Autowired
	@Qualifier(value = "contactBankDetailDaoImpl")
	public void setContactBankDetailDao(IContactBankDetailDao contactBankDetailDao) {
		this.contactBankDetailDao = contactBankDetailDao;
	}
	
	@Override
	public List<ContactBankDetail> getContactBankDetailByContactId(long contactId){
		return getRepository().getContactBankDetailByContactId(contactId);
	}
	
	@Override
	public ResultCodeConstant validateData(ContactBankDetail contactBankDetail) {
		if (contactBankDetail == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}

		if (contactBankDetail.getContactId() < 0) {
			return ResultCodeConstant.CONTACT_BANK_DETAILS_CONTACT_GT_ZERO;
		}
		return ResultCodeConstant.SUCCESS;
	}

}
