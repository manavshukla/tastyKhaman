package com.aone.module.proForma.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.proForma.controller.IProFormaController;
import com.aone.module.proForma.model.ProForma;
import com.aone.module.proForma.service.IProFormaService;

@RestController
@RequestMapping("/rest/proForma")
public class ProFormaRestController extends AbstractBaseMasterRestController<ProForma   , Long, IProFormaService> implements IProFormaController {
	
	private IProFormaService proFormaService;
	
	@Override
	public IProFormaService getService() {
		return getProFormaService();
	}

	public IProFormaService getProFormaService() {
		return proFormaService;
	}

	@Autowired        
	@Qualifier(value="proFormaServiceImpl")
	public void setPerFormaService(IProFormaService perFormaService) {
		this.proFormaService = perFormaService;
	}
}
