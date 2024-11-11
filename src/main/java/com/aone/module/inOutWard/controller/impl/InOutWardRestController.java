package com.aone.module.inOutWard.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.inOutWard.controller.IInOutWardController;
import com.aone.module.inOutWard.model.InOutWard;
import com.aone.module.inOutWard.service.IInOutWardService;

@RestController
@RequestMapping("/rest/inOutWard")
public class InOutWardRestController extends AbstractBaseMasterRestController<InOutWard , Long, IInOutWardService> implements IInOutWardController {
	
	private IInOutWardService inOutWardService;
	
	@Override
	public IInOutWardService getService() {
		return getInOutWardService();
	}

	public IInOutWardService getInOutWardService() {
		return inOutWardService;
	}

	@Autowired        
	@Qualifier(value="inOutWardServiceImpl")
	public void setInOutWardService(IInOutWardService inOutWardService) {
		this.inOutWardService = inOutWardService;
	}

}
