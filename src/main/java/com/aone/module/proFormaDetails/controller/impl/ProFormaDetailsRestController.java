package com.aone.module.proFormaDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.proFormaDetails.controller.IProFormaDetailsController;
import com.aone.module.proFormaDetails.model.ProFormaDetails;
import com.aone.module.proFormaDetails.service.IProFormaDetailsService;

@RestController
@RequestMapping("/rest/proFormaDetails")
public class ProFormaDetailsRestController extends AbstractBaseMasterRestController<ProFormaDetails , Long, IProFormaDetailsService  > implements IProFormaDetailsController {
	
	private IProFormaDetailsService proFormaDetailsService;
	
	@Override
	public IProFormaDetailsService getService() {
		return getProFormaDetailsService();
	}

	public IProFormaDetailsService getProFormaDetailsService() {
		return proFormaDetailsService;
	}

	@Autowired        
	@Qualifier(value="proFormaDetailsServiceImpl")
	public void setPerFormaDetailsService(IProFormaDetailsService proFormaDetailsService) {
		this.proFormaDetailsService = proFormaDetailsService;
	}
}
