package com.aone.module.contactCategory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.contactCategory.dao.IContactCategoryDao;
import com.aone.module.contactCategory.model.ContactCategory;
import com.aone.module.contactCategory.service.IContactCategoryService;

@Lazy
@Service("contactCategoryServiceImpl")
public class ContactCategoryServiceImpl extends AbstractBaseMasterService<ContactCategory, Long, IContactCategoryDao>
		implements IContactCategoryService {
	
	private IContactCategoryDao contactCategoryDao;

	@Override
	public IContactCategoryDao getRepository() {
		return getContactCategoryDao();
	}

	public IContactCategoryDao getContactCategoryDao() {
		return contactCategoryDao;
	}

	@Autowired
	@Qualifier(value = "contactCategoryDaoImpl")
	public void setContactCategoryDao(IContactCategoryDao contactCategoryDao) {
		this.contactCategoryDao = contactCategoryDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkContactCategoryName(RequestData<ContactCategory, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(ContactCategory contactCategory) {
		if(contactCategory == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(contactCategory.getName() == null || contactCategory.getName().isEmpty()) {
			return ResultCodeConstant.CONTACT_CATEGORY_NAME_NOT_FOUND;
		}
		// check if category name already exist
		if(!getRepository().checkUniqueDataByField("name", contactCategory.getName(), "id", contactCategory.getId()).isEmpty()) {
			return ResultCodeConstant.CONTACT_CATEGORY_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}

	@Override
	public List<ContactCategory> getByFieldName(String fieldName, Object value) {
		return contactCategoryDao.getByFieldName(fieldName, value);
	}
	
}