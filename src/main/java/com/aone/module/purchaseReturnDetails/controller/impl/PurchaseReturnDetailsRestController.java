package com.aone.module.purchaseReturnDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.purchaseReturnDetails.controller.IPurchaseReturnDetailsController;
import com.aone.module.purchaseReturnDetails.model.PurchaseReturnDetails;
import com.aone.module.purchaseReturnDetails.service.IPurchaseReturnDetailsService;

@RestController
@RequestMapping("/rest/purchaseReturnDetails")
public class PurchaseReturnDetailsRestController extends AbstractBaseMasterRestController<PurchaseReturnDetails , Long, IPurchaseReturnDetailsService> implements IPurchaseReturnDetailsController {
	
	private IPurchaseReturnDetailsService purchaseReturnDetailsService;
	
	@Override
	public IPurchaseReturnDetailsService getService() {
		return getPurchaseReturnDetailsService();
	}

	public IPurchaseReturnDetailsService getPurchaseReturnDetailsService() {
		return purchaseReturnDetailsService;
	}

	@Autowired        
	@Qualifier(value="purchaseReturnDetailsServiceImpl")
	public void setPurchaseReturnDetailsService(IPurchaseReturnDetailsService purchaseReturnDetailsService) {
		this.purchaseReturnDetailsService = purchaseReturnDetailsService;
	}

}
