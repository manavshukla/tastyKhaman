package com.aone.module.reports.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.reports.dao.IReportsDao;
import com.aone.module.reports.model.DueOrders;
import com.aone.module.reports.model.EmployeeReports;
import com.aone.module.reports.model.Reports;
import com.aone.module.reports.service.IReportsService;

@Lazy
@Service("reportsServiceImpl")
public class ReportsServiceImpl extends AbstractBaseMasterService<Reports, Long, IReportsDao>
		implements IReportsService {

	private IReportsDao reportsDao;

	@Override
	public IReportsDao getRepository() {
		return getReportsDao();
	}

	public IReportsDao getReportsDao() {
		return reportsDao;
	}

	@Autowired
	@Qualifier(value = "reportsDaoImpl")
	public void setReportsDao(IReportsDao reportsDao) {
		this.reportsDao = reportsDao;
	}
	
	public ResponseEntity<IResponseData<DueOrders>> getDueOrders(RequestData<SearchData<DueOrders>, Long> requestData){
		LocalDateTime startDate =  LocalDateTime.now();
		startDate = startDate.withHour(0);
		startDate = startDate.withMinute(0);
		startDate = startDate.withSecond(0);
		startDate = startDate.withNano(0);
		LocalDateTime endDate = startDate.plusDays(7);
		IResponseData<DueOrders> responseData = new ResponseData<>(reportsDao.getDueOrders(7, startDate, endDate), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	public ResponseEntity<IResponseData<EmployeeReports>> getEmployeeReports(RequestData<SearchData<EmployeeReports>, Long> requestData){
		LocalDateTime endDate =  LocalDateTime.now().plusDays(1);
		endDate = endDate.withHour(0);
		endDate = endDate.withMinute(0);
		endDate = endDate.withSecond(0);
		endDate = endDate.withNano(0);
		LocalDateTime startDate = endDate.minusDays(100);
		IResponseData<EmployeeReports> responseData = new ResponseData<>(reportsDao.getEmployeeReports(100, startDate, endDate), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
}
