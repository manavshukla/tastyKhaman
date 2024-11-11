package com.aone.module.purchase.controller.impl;

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
import com.aone.module.contact.model.Contact;
import com.aone.module.purchase.controller.IPurchaseController;
import com.aone.module.purchase.model.Purchase;
import com.aone.module.purchase.service.IPurchaseService;

@RestController
@RequestMapping("/rest/purchase")
@SecurityClassRole(baseRoleName = SecurityRoleModule.PURCHASE)
public class PurchaseRestController extends AbstractBaseMasterRestController<Purchase, Long, IPurchaseService> implements IPurchaseController {
	
	private IPurchaseService purchaseService;
	
	@Override
	public IPurchaseService getService() {
		return getPurchaseService();
	}

	public IPurchaseService getPurchaseService() {
		return purchaseService;
	}

	@Autowired        
	@Qualifier(value="purchaseServiceImpl")
	public void setPurchaseService(IPurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<IResponseData<Purchase>> getActiveData(@RequestBody RequestData<SearchData<Purchase>, Long> requestData) {
		return super.getActiveData(requestData);
	}
}