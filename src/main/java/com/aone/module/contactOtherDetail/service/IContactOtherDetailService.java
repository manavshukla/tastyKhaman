package com.aone.module.contactOtherDetail.service;

import java.util.List;

import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.contactOtherDetail.model.ContactOtherDetail;

public interface IContactOtherDetailService  extends IBaseMasterService<ContactOtherDetail  , Long>{

	public List<ContactOtherDetail> getOtherDetailByContactId(long contactId);
}
