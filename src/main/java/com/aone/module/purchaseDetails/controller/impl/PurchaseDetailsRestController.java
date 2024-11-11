package com.aone.module.purchaseDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.purchaseDetails.controller.IPurchaseDetailsController;
import com.aone.module.purchaseDetails.model.PurchaseDetails;
import com.aone.module.purchaseDetails.service.IPurchaseDetailsService;

@RestController
@RequestMapping("/rest/purchaseDetails")
public class PurchaseDetailsRestController extends AbstractBaseMasterRestController<PurchaseDetails , Long, IPurchaseDetailsService> implements IPurchaseDetailsController {
	
	private IPurchaseDetailsService purchaseDetailsService;
	
	@Override
	public IPurchaseDetailsService getService() {
		return getPurchaseDetailsService();
	}

	public IPurchaseDetailsService getPurchaseDetailsService() {
		return purchaseDetailsService;
	}

	@Autowired        
	@Qualifier(value="purchaseDetailsServiceImpl")
	public void setPurchaseDetailsService(IPurchaseDetailsService purchaseDetailsService) {
		this.purchaseDetailsService = purchaseDetailsService;
	}

}
