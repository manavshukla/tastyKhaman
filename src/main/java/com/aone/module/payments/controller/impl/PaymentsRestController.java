package com.aone.module.payments.controller.impl;

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
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.payments.controller.IPaymentsController;
import com.aone.module.payments.model.PaymentListData;
import com.aone.module.payments.model.PaymentsMaster;
import com.aone.module.payments.service.IPaymentsService;

@RestController
@RequestMapping("/rest/paymentsMaster")
public class PaymentsRestController extends AbstractBaseMasterRestController<PaymentsMaster, Long, IPaymentsService> implements IPaymentsController {

	private IPaymentsService paymentsService;

	public IPaymentsService getPaymentsService() {
		return paymentsService;
	}

	@Autowired
	@Qualifier(value="paymentsServiceImpl")
	public void setPaymentsService(IPaymentsService paymentsService) {
		this.paymentsService = paymentsService;
	}

	@Override
	public IPaymentsService getService() {
		return getPaymentsService();
	}
	
	@Override
	@RequestMapping(value="/getPaymentListData", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody ResponseEntity<IResponseData<PaymentListData>> getPaymentListData(@RequestBody RequestData<SearchData<PaymentsMaster>, Long> requestData){
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return getService().getPaymentListData(requestData);
	}
	
}
