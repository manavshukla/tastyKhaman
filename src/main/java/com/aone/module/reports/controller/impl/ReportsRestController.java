package com.aone.module.reports.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.reports.controller.IReportsController;
import com.aone.module.reports.model.DueOrders;
import com.aone.module.reports.model.EmployeeReports;
import com.aone.module.reports.model.Reports;
import com.aone.module.reports.service.IReportsService;

@RestController
@RequestMapping("/rest/reports")
@SecurityClassRole(baseRoleName = SecurityRoleModule.REPORTS)
public class ReportsRestController extends AbstractBaseMasterRestController<Reports, Long, IReportsService> implements IReportsController {

	private IReportsService reportsService;
	
	@Override
	public IReportsService getService() {
		return getReportsService();
	}

	public IReportsService getReportsService() {
		return reportsService;
	}

	@Autowired
	@Qualifier(value="reportsServiceImpl")
	public void setReportsService(IReportsService reportsService) {
		this.reportsService = reportsService;
	}
	
	@Override
	@RequestMapping(value="/getDueOrders", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<DueOrders>> getDueOrders(@RequestBody RequestData<SearchData<DueOrders>, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getDueOrders(requestData);
	}
	
	
	@Override
	@RequestMapping(value="/getEmployeeReports", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<EmployeeReports>> getEmployeeReports(@RequestBody RequestData<SearchData<EmployeeReports>, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getEmployeeReports(requestData);
	}
}
