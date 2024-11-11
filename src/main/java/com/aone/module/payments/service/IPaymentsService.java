package com.aone.module.payments.service;

import org.springframework.http.ResponseEntity;

import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.SearchData;
import com.aone.corelibrary.service.IBaseMasterService;
import com.aone.module.payments.model.PaymentListData;
import com.aone.module.payments.model.PaymentsMaster;

public interface IPaymentsService extends IBaseMasterService<PaymentsMaster, Long> {

	public ResponseEntity<IResponseData<PaymentListData>> getPaymentListData(RequestData<SearchData<PaymentsMaster>, Long> requestData);

	public int deleteByBillId(long billId, String entryType);
}
