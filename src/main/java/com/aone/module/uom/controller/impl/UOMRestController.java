package com.aone.module.uom.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.uom.controller.IUOMController;
import com.aone.module.uom.model.UOM;
import com.aone.module.uom.service.IUOMService;

@RestController
@RequestMapping("/rest/uom")
@SecurityClassRole(baseRoleName = SecurityRoleModule.UOM)
public class UOMRestController extends AbstractBaseMasterRestController<UOM, Long, IUOMService> implements IUOMController {
	
	private IUOMService uomService;
	
	@Override
	public IUOMService getService() {
		return getUomService();
	}

	/**
	 * @return the uomService
	 */
	public IUOMService getUomService() {
		return uomService;
	}

	/**
	 * @param uomService the uomService to set
	 */
	@Autowired        
	@Qualifier(value="uomServiceImpl")
	public void setUomService(IUOMService uomService) {
		this.uomService = uomService;
	}
	
	@Override
	@RequestMapping(value="/checkUOMCode", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkUOMCode(@RequestBody RequestData<UOM,Long> requestData) {
		return getService().checkUOMName(requestData);
	}
	
}
