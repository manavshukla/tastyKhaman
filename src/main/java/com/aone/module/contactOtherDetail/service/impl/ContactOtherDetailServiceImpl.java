package com.aone.module.contactOtherDetail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.contactOtherDetail.dao.IContactOtherDetailDao;
import com.aone.module.contactOtherDetail.model.ContactOtherDetail;
import com.aone.module.contactOtherDetail.service.IContactOtherDetailService;

@Lazy
@Service("contactOtherDetailServiceImpl")
public class ContactOtherDetailServiceImpl extends AbstractBaseMasterService<ContactOtherDetail   , Long, IContactOtherDetailDao    >
		implements IContactOtherDetailService  {

	private IContactOtherDetailDao  contactOtherDetailDao;

	@Override
	public IContactOtherDetailDao getRepository() {
		return getContactOtherDetailDao();
	}

	public IContactOtherDetailDao getContactOtherDetailDao() {
		return contactOtherDetailDao;
	}

	@Autowired
	@Qualifier(value = "contactOtherDetailDaoImpl")
	public void setContactOtherDetailDao(IContactOtherDetailDao contactOtherDetailDao) {
		this.contactOtherDetailDao = contactOtherDetailDao;
	}
	
	@Override
	public List<ContactOtherDetail> getOtherDetailByContactId(long contactId) {
		return getRepository().getOtherDetailByContactId(contactId);
	}
	
	@Override
	public ResultCodeConstant validateData(ContactOtherDetail contactOtherDetail) {
		if (contactOtherDetail == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}

		if (contactOtherDetail.getContactId() < 0) {
			return ResultCodeConstant.CONTACT_OTHER_DETAILS_CONTACT_GT_ZERO;
		}
		return ResultCodeConstant.SUCCESS;
	}

}
