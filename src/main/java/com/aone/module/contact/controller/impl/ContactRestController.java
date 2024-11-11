package com.aone.module.contact.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.contact.controller.IContactController;
import com.aone.module.contact.model.Contact;
import com.aone.module.contact.model.ContactListData;
import com.aone.module.contact.service.IContactService;

@RestController
@RequestMapping("/rest/contact")
@SecurityClassRole(baseRoleName = SecurityRoleModule.CONTACT)
public class ContactRestController extends AbstractBaseMasterRestController<Contact, Long, IContactService > implements IContactController  {
	
	private IContactService contactService;
	
	@Override
	public IContactService getService() {
		return getContactService();
	}

	/**
	 * @return the contactService
	 */
	public IContactService getContactService() {
		return contactService;
	}

	/**
	 * @param contactService the contactService to set
	 */
	@Autowired        
	@Qualifier(value="contactServiceImpl")
	public void setContactService(IContactService contactService) {
		this.contactService = contactService;
	}
	
	@Override
	@RequestMapping(value="/getCategorialContacts", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<ContactListData>> getContactListData(@RequestBody RequestData<SearchData<Contact>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getContactListData(requestData);
	}
	
	@Override
	@RequestMapping(value="/getCustomer", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<ContactListData>> getCustomer(@RequestBody RequestData<SearchData<Contact>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getCustomer(requestData);
	}
	
	@Override
	@RequestMapping(value="/getDriver", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<ContactListData>> getDriver(@RequestBody RequestData<SearchData<Contact>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getDriver(requestData);
	}
	
	@Override
	@RequestMapping(value="/getRetailer", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<ContactListData>> getRetailer(@RequestBody RequestData<SearchData<Contact>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getRetailer(requestData);
	}
	
	@Override
	@RequestMapping(value="/getThirdParty", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<ContactListData>> getThirdParty(@RequestBody RequestData<SearchData<Contact>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getThirdParty(requestData);
	}
	
	@Override
	@RequestMapping(value="/getVendorDealer", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<ContactListData>> getVendorDealer(@RequestBody RequestData<SearchData<Contact>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getVendorDealer(requestData);
	}
	
	@Override
	@RequestMapping(value="/getWorkerHelper", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<ContactListData>> getWorkerHelper(@RequestBody RequestData<SearchData<Contact>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getWorkerHelper(requestData);
	}
	
	@Override
	@RequestMapping(value="/getOther", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<ContactListData>> getOther(@RequestBody RequestData<SearchData<Contact>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getOther(requestData);
	}

	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<IResponseData<Contact>> getActiveData(@RequestBody RequestData<SearchData<Contact>, Long> requestData) {
		return super.getActiveData(requestData);
	}
}
