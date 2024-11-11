package com.aone.module.reports.controller;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.reports.model.DueOrders;
import com.aone.module.reports.model.EmployeeReports;
import com.aone.module.reports.model.Reports;

public interface IReportsController extends IBaseMasterController<Reports, Long> {

	public ResponseEntity<IResponseData<DueOrders>> getDueOrders(RequestData<SearchData<DueOrders>, Long> requestData);
	public ResponseEntity<IResponseData<EmployeeReports>> getEmployeeReports(RequestData<SearchData<EmployeeReports>, Long> requestData);
}
