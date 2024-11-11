package com.aone.module.purchaseOrder.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.purchaseOrder.controller.IPurchaseOrderController;
import com.aone.module.purchaseOrder.model.PurchaseOrder;
import com.aone.module.purchaseOrder.service.IPurchaseOrderService;

@RestController
@RequestMapping("/rest/purchaseOrder")
public class PurchaseOrderRestController extends AbstractBaseMasterRestController<PurchaseOrder , Long, IPurchaseOrderService> implements IPurchaseOrderController {
	
	private IPurchaseOrderService purchaseOrderService;
	
	@Override
	public IPurchaseOrderService getService() {
		return getPurchaseOrderService();
	}

	public IPurchaseOrderService getPurchaseOrderService() {
		return purchaseOrderService;
	}

	@Autowired        
	@Qualifier(value="purchaseOrderServiceImpl")
	public void setPurchaseOrderService(IPurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
}
