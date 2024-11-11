package com.aone.module.reports.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.reports.model.DueOrders;
import com.aone.module.reports.model.EmployeeReports;
import com.aone.module.reports.model.Reports;

public interface IReportsDao extends IBaseMasterRepository<Reports, Long> {

	public List<DueOrders> getDueOrders(int days, LocalDateTime startDate, LocalDateTime endDate);
	public List<EmployeeReports> getEmployeeReports(int days, LocalDateTime startDate, LocalDateTime endDate);
}
