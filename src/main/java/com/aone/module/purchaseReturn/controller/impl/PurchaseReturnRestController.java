package com.aone.module.purchaseReturn.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.purchaseReturn.controller.IPurchaseReturnController;
import com.aone.module.purchaseReturn.model.PurchaseReturn;
import com.aone.module.purchaseReturn.service.IPurchaseReturnService;

@RestController
@RequestMapping("/rest/purchaseReturn")
@SecurityClassRole(baseRoleName = SecurityRoleModule.PURCHASE_RETURN)
public class PurchaseReturnRestController extends AbstractBaseMasterRestController<PurchaseReturn , Long, IPurchaseReturnService> implements IPurchaseReturnController {
	
	private IPurchaseReturnService purchaseReturnService;
	
	@Override
	public IPurchaseReturnService getService() {
		return getPurchaseReturnService();
	}

	public IPurchaseReturnService getPurchaseReturnService() {
		return purchaseReturnService;
	}

	@Autowired        
	@Qualifier(value="purchaseReturnServiceImpl")
	public void setPurchaseReturnService(IPurchaseReturnService purchaseReturnService) {
		this.purchaseReturnService = purchaseReturnService;
	}
}
