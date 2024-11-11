package com.aone.module.quotation.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.quotation.controller.IQuotationController;
import com.aone.module.quotation.model.Quotation;
import com.aone.module.quotation.service.IQuotationService;

@RestController
@RequestMapping("/rest/quotation")
public class QuotationRestController extends AbstractBaseMasterRestController<Quotation , Long, IQuotationService> implements IQuotationController {
	
	private IQuotationService quotationService;
	
	@Override
	public IQuotationService getService() {
		return getQuotationService();
	}

	public IQuotationService getQuotationService() {
		return quotationService;
	}

	@Autowired        
	@Qualifier(value="quotationServiceImpl")
	public void setQuotationService(IQuotationService quotationService) {
		this.quotationService = quotationService;
	}
}
