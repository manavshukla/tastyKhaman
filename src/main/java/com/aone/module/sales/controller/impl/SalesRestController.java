package com.aone.module.sales.controller.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.address.service.IAddressService;
import com.aone.module.city.service.ICityService;
import com.aone.module.country.service.ICountryService;
import com.aone.module.sales.controller.ISalesController;
import com.aone.module.sales.model.Sales;
import com.aone.module.sales.service.ISalesService;
import com.aone.module.sales.util.SalesUtil;
import com.aone.module.state.service.IStateService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
@RequestMapping("/rest/sales")
@SecurityClassRole(baseRoleName = SecurityRoleModule.SALES)	
public class SalesRestController extends AbstractBaseMasterRestController<Sales , Long, ISalesService> implements ISalesController {
	
	private ISalesService salesService;
	private IAddressService addressService;
	private ICountryService countryService;
	private IStateService stateService;
	private ICityService cityService;
	
	public ICityService getCityService() {
		return cityService;
	}

	@Autowired
	@Qualifier(value = "cityServiceImpl")
	public void setCityService(ICityService cityService) {
		this.cityService = cityService;
	}

	public IStateService getStateService() {
		return stateService;
	}

	@Autowired
	@Qualifier(value = "stateServiceImpl")
	public void setStateService(IStateService stateService) {
		this.stateService = stateService;
	}

	public ICountryService getCountryService() {
		return countryService;
	}

	@Autowired
	@Qualifier(value = "countryServiceImpl")
	public void setCountryService(ICountryService countryService) {
		this.countryService = countryService;
	}
	
	public IAddressService getAddressService() {
		return addressService;
	}

	@Autowired
	@Qualifier(value = "addressServiceImpl")
	public void setAddressService(IAddressService addressService) {
		this.addressService = addressService;
	}
	
	@Override
	public ISalesService getService() {
		return getSalesService();
	}

	public ISalesService getSalesService() {
		return salesService;
	}

	@Autowired        
	@Qualifier(value="salesServiceImpl")
	public void setSalesService(ISalesService salesService) {
		this.salesService = salesService;
	}
	
	@Override
	@RequestMapping(value="/getActiveData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<Sales>> getActiveData(@RequestBody RequestData<SearchData<Sales>, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getActiveData(requestData);
	}
	
	@RequestMapping(value="/printOrderBill", method=RequestMethod.GET)
	public void printBomEstimate(@RequestParam Long orderNo, HttpServletResponse response) {
		String fileName = new SimpleDateFormat("'Order_'"+orderNo+"'_'yyyyMMddHHmm'.pdf'").format(new Date());
		 try {
				Sales sales = new Sales();
				sales.setId(orderNo);
				sales = salesService.getById(sales);
				InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/Bill.jasper");
				Map<String,Object> params = SalesUtil.getParamesterForPrintBill(sales, addressService, cityService, stateService, countryService);
			    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
			    response.setContentType("application/x-pdf");
			    response.setHeader("Content-disposition", "inline; filename="+fileName);
			    final OutputStream outStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
