package com.aone.module.contactCategory.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.contactCategory.controller.IContactCategoryController;
import com.aone.module.contactCategory.model.ContactCategory;
import com.aone.module.contactCategory.service.IContactCategoryService;

@RestController
@RequestMapping("/rest/contactCategory")
@SecurityClassRole(baseRoleName = SecurityRoleModule.CONTACT_CATEGORY)
public class ContactCategoryRestController extends AbstractBaseMasterRestController<ContactCategory , Long, IContactCategoryService> implements IContactCategoryController {
	
	private IContactCategoryService contactCategoryService;
	
	@Override
	public IContactCategoryService getService() {
		return getContactCategoryService();
	}

	public IContactCategoryService getContactCategoryService() {
		return contactCategoryService;
	}

	@Autowired        
	@Qualifier(value="contactCategoryServiceImpl")
	public void setContactCategoryService(IContactCategoryService contactCategoryService) {
		this.contactCategoryService = contactCategoryService;
	}
	
	@Override
	@RequestMapping(value="/checkContactCategoryName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkContactCategoryName(@RequestBody RequestData<ContactCategory,Long> requestData) {
		return getService().checkContactCategoryName(requestData);
	}

}
