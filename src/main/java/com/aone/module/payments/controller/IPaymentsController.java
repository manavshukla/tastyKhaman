package com.aone.module.payments.controller;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.controller.IBaseMasterController;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.module.payments.model.PaymentListData;
import com.aone.module.payments.model.PaymentsMaster;

public interface IPaymentsController extends IBaseMasterController<PaymentsMaster, Long> {

	public ResponseEntity<IResponseData<PaymentListData>> getPaymentListData(
			RequestData<SearchData<PaymentsMaster>, Long> requestData);

}
