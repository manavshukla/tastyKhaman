package com.aone.module.newReports.controller.impl;

import java.io.File;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.commons.utils.DateUtils;
import com.aone.commons.utils.FileUtils;
import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.module.files.constant.FilesDataModuleName;
import com.aone.module.files.service.IFilesDataService;
import com.aone.module.newReports.controller.INewReportsController;
import com.aone.module.newReports.model.NewReportsData;
import com.aone.module.newReports.service.INewReportsService;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping("/rest/newReports")
public class NewReportsRestController implements INewReportsController {

	private INewReportsService reportsService;
	private IFilesDataService filesDataService;

	public IFilesDataService getFilesDataService() {
		return filesDataService;
	}

	@Autowired
	@Qualifier(value = "filesDataServiceImpl")
	public void setFilesDataService(IFilesDataService filesDataService) {
		this.filesDataService = filesDataService;
	}

	public INewReportsService getReportsService() {
		return reportsService;
	}

	@Autowired
	@Qualifier(value = "newReportsServiceImpl")
	public void setReportsService(INewReportsService reportsService) {
		this.reportsService = reportsService;
	}

	@RequestMapping(value = "/itemSaleReport", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<IResponseData<NewReportsData>> itemSaleReport(
			@RequestBody RequestData<NewReportsData, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		NewReportsData reportsData = requestData.getData();
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reports/ItemReport.jrxml");
			Map<String, Object> params = new HashMap<>();
			params.put("startDate", DateUtils.getUIDateFormatted(reportsData.getStartDateTime()));
			params.put("endDate", DateUtils.getUIDateFormatted(reportsData.getEndDateTime()));
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					new JRResultSetDataSource(reportsService.getItemWiseSalesReportDetails(reportsData)));
			String baseFilePath = FilesDataModuleName.REPORTS.getPath() + File.separator
					+ FileUtils.getFileName("itemSaleReport.pdf");
			String filePath = filesDataService.getBasePath() + File.separator + baseFilePath;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
			reportsData.setReportPath(baseFilePath);

			IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.SUCCESS);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.INTERNAL_ERROR);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}

	@RequestMapping(value = "/employeeReport", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<IResponseData<NewReportsData>> employeeReport(@RequestBody RequestData<NewReportsData, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		NewReportsData reportsData = requestData.getData();
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reports/EmployeeReport.jrxml");
			Map<String, Object> params = new HashMap<>();
			params.put("startDate", DateUtils.getUIDateFormatted(reportsData.getStartDateTime()));
			params.put("endDate", DateUtils.getUIDateFormatted(reportsData.getEndDateTime()));
			params.put("contactId", reportsData.getContactId());
			params.put("contactCategoryId", reportsData.getContactCategoryId());
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JRResultSetDataSource(reportsService.getEmployeeReport(reportsData)));
			String baseFilePath = FilesDataModuleName.REPORTS.getPath() + File.separator + FileUtils.getFileName("EmployeeReport.pdf");
			String filePath = filesDataService.getBasePath() + File.separator + baseFilePath;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
			reportsData.setReportPath(baseFilePath);
			if(reportsData.getStartDateTime() !=null) {
				reportsData.setPreBalance(reportsService.getTotalPreBalance(reportsData));
			}
			IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.SUCCESS);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.INTERNAL_ERROR);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rawPurchaseReport", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<IResponseData<NewReportsData>> rawPurchaseReport(
			@RequestBody RequestData<NewReportsData, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		NewReportsData reportsData = requestData.getData();
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reports/RawPurchaseReport.jrxml");
			Map<String, Object> params = new HashMap<>();
			params.put("startDate", DateUtils.getUIDateFormatted(reportsData.getStartDateTime()));
			params.put("endDate", DateUtils.getUIDateFormatted(reportsData.getEndDateTime()));
			params.put("contactName", reportsData.getContactName());
			params.put("contactNo", reportsData.getContactNo());
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					new JRResultSetDataSource(reportsService.getRowPurchaseReportDetails(reportsData)));
			String baseFilePath = FilesDataModuleName.REPORTS.getPath() + File.separator
					+ FileUtils.getFileName("RawPurchaseReport.pdf");
			String filePath = filesDataService.getBasePath() + File.separator + baseFilePath;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
			reportsData.setReportPath(baseFilePath);

			IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.SUCCESS);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.INTERNAL_ERROR);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/workerHelperReport", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<IResponseData<NewReportsData>> workerHelperReport(
			@RequestBody RequestData<NewReportsData, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		NewReportsData reportsData = requestData.getData();
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reports/WorkerHelperReport.jrxml");
			Map<String, Object> params = new HashMap<>();
			params.put("startDate", DateUtils.getUIDateFormatted(reportsData.getStartDateTime()));
			params.put("endDate", DateUtils.getUIDateFormatted(reportsData.getEndDateTime()));
			params.put("contactName", reportsData.getContactName());
			params.put("contactNo", reportsData.getContactNo());
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					new JRResultSetDataSource(reportsService.getWorkerHelperReportDetails(reportsData)));
			String baseFilePath = FilesDataModuleName.REPORTS.getPath() + File.separator
					+ FileUtils.getFileName("WorkerHelperReport.pdf");
			String filePath = filesDataService.getBasePath() + File.separator + baseFilePath;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
			reportsData.setReportPath(baseFilePath);

			IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.SUCCESS);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.INTERNAL_ERROR);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/driverReport", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<IResponseData<NewReportsData>> driverReport(
			@RequestBody RequestData<NewReportsData, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		NewReportsData reportsData = requestData.getData();
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reports/DriverReport.jrxml");
			Map<String, Object> params = new HashMap<>();
			params.put("startDate", DateUtils.getUIDateFormatted(reportsData.getStartDateTime()));
			params.put("endDate", DateUtils.getUIDateFormatted(reportsData.getEndDateTime()));
			params.put("contactName", reportsData.getContactName());
			params.put("vehicleNo", reportsData.getVehicleNo());
			params.put("contactNo", reportsData.getContactNo());
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					new JRResultSetDataSource(reportsService.getDriverReportDetails(reportsData)));
			String baseFilePath = FilesDataModuleName.REPORTS.getPath() + File.separator
					+ FileUtils.getFileName("DriverReport.pdf");
			String filePath = filesDataService.getBasePath() + File.separator + baseFilePath;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
			reportsData.setReportPath(baseFilePath);

			IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.SUCCESS);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.INTERNAL_ERROR);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/thirdPartyReport", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<IResponseData<NewReportsData>> thirdPartyReport(
			@RequestBody RequestData<NewReportsData, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		NewReportsData reportsData = requestData.getData();
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reports/ThirdPartyReport.jrxml");
			Map<String, Object> params = new HashMap<>();
			params.put("startDate", DateUtils.getUIDateFormatted(reportsData.getStartDateTime()));
			params.put("endDate", DateUtils.getUIDateFormatted(reportsData.getEndDateTime()));
			params.put("contactName", reportsData.getContactName());
			params.put("vehicleNo", reportsData.getVehicleNo());
			params.put("contactNo", reportsData.getContactNo());
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					new JRResultSetDataSource(reportsService.getThirdPartyDetails(reportsData)));
			String baseFilePath = FilesDataModuleName.REPORTS.getPath() + File.separator
					+ FileUtils.getFileName("ThirdPartyReport.pdf");
			String filePath = filesDataService.getBasePath() + File.separator + baseFilePath;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
			reportsData.setReportPath(baseFilePath);

			IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.SUCCESS);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.INTERNAL_ERROR);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pendingPaymentReport", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<IResponseData<NewReportsData>> pendingPaymentReport(
			@RequestBody RequestData<NewReportsData, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		NewReportsData reportsData = requestData.getData();
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reports/PendingPaymentReport.jrxml");
			Map<String, Object> params = new HashMap<>();
			params.put("startDate", DateUtils.getUIDateFormatted(reportsData.getStartDateTime()));
			params.put("endDate", DateUtils.getUIDateFormatted(reportsData.getEndDateTime()));
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					new JRResultSetDataSource(reportsService.getPendingPaymentReportDetails(reportsData)));
			String baseFilePath = FilesDataModuleName.REPORTS.getPath() + File.separator
					+ FileUtils.getFileName("PendingPaymentReport.pdf");
			String filePath = filesDataService.getBasePath() + File.separator + baseFilePath;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
			reportsData.setReportPath(baseFilePath);

			IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.SUCCESS);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.INTERNAL_ERROR);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/wholeSaleReport", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<IResponseData<NewReportsData>> wholeSaleReport(
			@RequestBody RequestData<NewReportsData, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		NewReportsData reportsData = requestData.getData();
		try {
			InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/reports/WholeSaleReport.jrxml");
			InputStream jasperStreamSubReport = this.getClass().getResourceAsStream("/jasperreports/reports/WholeSaleReport_subreport1.jrxml");
			Map<String, Object> params = new HashMap<>();
			if(reportsData.getStartDateTime() != null) {
				params.put("startDate", DateUtils.getMySqlDbStartDateFormatted(reportsData.getStartDateTime()));
				params.put("startDateUI", DateUtils.getUIDateFormatted(reportsData.getStartDateTime()));
			}else {
				params.put("startDate", "1990-01-01 00:00:00");
				params.put("startDateUI", "");
			}
			
			if(reportsData.getStartDateTime() != null) {
				params.put("endDate", DateUtils.getMySqlDbEndDateFormatted(reportsData.getEndDateTime()));
				params.put("endDateUI", DateUtils.getUIDateFormatted(reportsData.getEndDateTime()));
			}else {
				params.put("endDate", DateUtils.getMySqlDbEndDateFormatted(LocalDateTime.now()));
				params.put("endDateUI", DateUtils.getUIDateFormatted(LocalDateTime.now()));
			}
			
			params.put("contactName", reportsData.getContactName());
			params.put("contactId", reportsData.getContactId());
			params.put("contactNo", reportsData.getContactNo());
			
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperStream);
			JasperReport jasperSubReport = JasperCompileManager.compileReport(jasperStreamSubReport);
			params.put("subreportParameter", jasperSubReport);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, reportsService.getReportConnection(reportsData));
			String baseFilePath = FilesDataModuleName.REPORTS.getPath() + File.separator
					+ FileUtils.getFileName("WholeSaleReport.pdf");
			String filePath = filesDataService.getBasePath() + File.separator + baseFilePath;
			JasperExportManager.exportReportToPdfFile(jasperPrint, filePath);
			reportsData.setReportPath(baseFilePath);

			IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.SUCCESS);
			responseData.setRequestToken(requestData.getRequestToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		IResponseData<NewReportsData> responseData = new ResponseData<>(reportsData, ResultCodeConstant.INTERNAL_ERROR);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
}
