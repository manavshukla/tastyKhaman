package com.aone.module.contactOtherDetail.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.contactOtherDetail.model.ContactOtherDetail;

public interface IContactOtherDetailDao extends IBaseMasterRepository<ContactOtherDetail  , Long>{
	
	public List<ContactOtherDetail> getOtherDetailByContactId(long contactId);

}
