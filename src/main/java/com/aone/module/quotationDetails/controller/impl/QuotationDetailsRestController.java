package com.aone.module.quotationDetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.quotationDetails.controller.IQuotationDetailsController;
import com.aone.module.quotationDetails.model.QuotationDetails;
import com.aone.module.quotationDetails.service.IQuotationDetailsService;

@RestController
@RequestMapping("/rest/quotationDetails")
public class QuotationDetailsRestController extends AbstractBaseMasterRestController<QuotationDetails  , Long, IQuotationDetailsService> implements IQuotationDetailsController {
	
	private IQuotationDetailsService quotationDetailsService;
	
	@Override
	public IQuotationDetailsService getService() {
		return getQuotationDetailsService();
	}

	public IQuotationDetailsService getQuotationDetailsService() {
		return quotationDetailsService;
	}

	@Autowired        
	@Qualifier(value="quotationDetailsServiceImpl")
	public void setQuotationDetailsService(IQuotationDetailsService quotationDetailsService) {
		this.quotationDetailsService = quotationDetailsService;
	}
}
