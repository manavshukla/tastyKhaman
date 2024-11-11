package com.aone.module.newReports.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.aone.module.newReports.model.NewReportsData;

public interface INewReportsService {

	public ResultSet getItemWiseSalesReportDetails(NewReportsData reportsData);
	public ResultSet getRowPurchaseReportDetails(NewReportsData reportsData);

	public ResultSet getEmployeeReport(NewReportsData reportsData);
	public Double getTotalPreBalance(NewReportsData reportsData);
	public ResultSet getWorkerHelperReportDetails(NewReportsData reportsData);
	public ResultSet getDriverReportDetails(NewReportsData reportsData);
	public ResultSet getThirdPartyDetails(NewReportsData reportsData);
	public ResultSet getPendingPaymentReportDetails(NewReportsData reportsData);
	public Connection getReportConnection(NewReportsData reportsData);
}
