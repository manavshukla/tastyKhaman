package com.aone.module.company.controller.impl;

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
import com.aone.module.company.controller.ICompanyController;
import com.aone.module.company.model.Company;
import com.aone.module.company.service.ICompanyService;

@RestController
@RequestMapping("/rest/company")
@SecurityClassRole(baseRoleName = SecurityRoleModule.BRAND)
public class CompanyRestController extends AbstractBaseMasterRestController<Company, Long, ICompanyService> implements ICompanyController {

	private ICompanyService companyService;
	
	@Override
	public ICompanyService getService() {
		return getCompanyService();
	}

	public ICompanyService getCompanyService() {
		return companyService;
	}

	@Autowired
	@Qualifier(value="companyServiceImpl")
	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}
	
	@Override
	@RequestMapping(value="/checkCompanyName", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Boolean>> checkCompanyName(@RequestBody RequestData<Company,Long> requestData) {
		return getService().checkCompanyName(requestData);
	}
	
}
