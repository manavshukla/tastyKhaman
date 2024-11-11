package com.aone.module.deliveryMethod.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.deliveryMethod.controller.IDeliveryMethodController;
import com.aone.module.deliveryMethod.model.DeliveryMethod;
import com.aone.module.deliveryMethod.service.IDeliveryMethodService;

@RestController
@RequestMapping("/rest/deliveryMethod")
public class DeliveryMethodRestController extends AbstractBaseMasterRestController<DeliveryMethod, Long, IDeliveryMethodService > implements IDeliveryMethodController  {
	
	private IDeliveryMethodService deliveryMethodService;
	
	@Override
	public IDeliveryMethodService getService() {
		return getDeliveryMethodService();
	}

	public IDeliveryMethodService getDeliveryMethodService() {
		return deliveryMethodService;
	}

	@Autowired        
	@Qualifier(value="deliveryMethodServiceImpl")
	public void setDeliveryMethodService(IDeliveryMethodService deliveryMethodService) {
		this.deliveryMethodService = deliveryMethodService;
	}
	
}
