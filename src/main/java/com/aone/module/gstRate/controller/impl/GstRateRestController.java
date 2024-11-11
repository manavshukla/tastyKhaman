package com.aone.module.gstRate.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.gstRate.controller.IGstRateController;
import com.aone.module.gstRate.model.GstRate;
import com.aone.module.gstRate.service.IGstRateService;

@RestController
@RequestMapping("/rest/gstRate")
@SecurityClassRole(baseRoleName = SecurityRoleModule.GST_RATE)
public class GstRateRestController extends AbstractBaseMasterRestController<GstRate , Long, IGstRateService > implements IGstRateController {
	
	private IGstRateService gstRateService;
	
	@Override
	public IGstRateService getService() {
		return getGstRateService();
	}

	public IGstRateService getGstRateService() {
		return gstRateService;
	}

	@Autowired        
	@Qualifier(value="gstRateServiceImpl")
	public void setGstRateService(IGstRateService gstRateService) {
		this.gstRateService = gstRateService;
	}
}
