package com.aone.module.purchaseOrderDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.purchaseOrderDetails.controller.IPurchaseOrderDetailsController;
import com.aone.module.purchaseOrderDetails.model.PurchaseOrderDetails;
import com.aone.module.purchaseOrderDetails.service.IPurchaseOrderDetailsService;

@RestController
@RequestMapping("/rest/purchaseOrderDetails")
public class PurchaseOrderDetailsRestController extends AbstractBaseMasterRestController<PurchaseOrderDetails  , Long, IPurchaseOrderDetailsService > implements IPurchaseOrderDetailsController {
	
	private IPurchaseOrderDetailsService purchaseOrderDetailsService;
	
	@Override
	public IPurchaseOrderDetailsService getService() {
		return getPurchaseOrderDetailsService();
	}

	public IPurchaseOrderDetailsService getPurchaseOrderDetailsService() {
		return purchaseOrderDetailsService;
	}

	@Autowired        
	@Qualifier(value="purchaseOrderDetailsServiceImpl")
	public void setPurchaseOrderDetailsService(IPurchaseOrderDetailsService purchaseOrderDetailsService) {
		this.purchaseOrderDetailsService = purchaseOrderDetailsService;
	}

}
