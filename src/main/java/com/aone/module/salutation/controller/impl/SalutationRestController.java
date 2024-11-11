package com.aone.module.salutation.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.salutation.controller.ISalutationController;
import com.aone.module.salutation.model.Salutation;
import com.aone.module.salutation.service.ISalutationService;

@RestController
@RequestMapping("/rest/salutation")
public class SalutationRestController extends AbstractBaseMasterRestController<Salutation , Long, ISalutationService> implements ISalutationController {
	
	private ISalutationService salutationService;
	
	@Override
	public ISalutationService getService() {
		return getSalutationService();
	}

	public ISalutationService getSalutationService() {
		return salutationService;
	}

	@Autowired        
	@Qualifier(value="salutationServiceImpl")
	public void setSalutationService(ISalutationService salutationService) {
		this.salutationService = salutationService;
	}
	
}
