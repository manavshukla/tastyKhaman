package com.aone.module.payments.service.impl;

import java.util.List;

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
import com.aone.module.payments.constant.PaymentConstant;
import com.aone.module.payments.dao.IPaymentsDao;
import com.aone.module.payments.model.PaymentListData;
import com.aone.module.payments.model.PaymentsMaster;
import com.aone.module.payments.service.IPaymentsService;

@Lazy
@Service("paymentsServiceImpl")
public class PaymentsServiceImpl extends AbstractBaseMasterService<PaymentsMaster, Long, IPaymentsDao>
		implements IPaymentsService {

	private IPaymentsDao paymentsDao;
	
	public IPaymentsDao getPaymentsDao() {
		return paymentsDao;
	}

	@Override
	public IPaymentsDao getRepository() {
		return getPaymentsDao();
	}

	@Autowired
	@Qualifier(value = "paymentsDaoImpl")
	public void setPaymentsDao(IPaymentsDao paymentsDao) {
		this.paymentsDao = paymentsDao;
	}



	@Override
	public ResultCodeConstant validateData(PaymentsMaster payments) {
		if(payments == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		return ResultCodeConstant.SUCCESS;
	}
	
	@Override
	public ResponseEntity<IResponseData<PaymentListData>> getPaymentListData(RequestData<SearchData<PaymentsMaster>, Long> requestData) {
		
		SearchData<PaymentsMaster> searchData = requestData.getData();
		
		PaymentsMaster paymentsMaster = searchData.getData();
		
		List<PaymentsMaster> creditList  = paymentsDao.getListByTransType(PaymentConstant.CREDIT, paymentsMaster.getContactId());
		List<PaymentsMaster> debitList  = paymentsDao.getListByTransType(PaymentConstant.DEBIT, paymentsMaster.getContactId());
	
		PaymentListData  paymentListData = new PaymentListData();
		paymentListData.setCrList(creditList);
		paymentListData.setDrList(debitList);
		
		IResponseData<PaymentListData> responseData = new ResponseData<>(paymentListData, ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	public int deleteByBillId(long billId, String entryType) {
		return paymentsDao.deleteByBillId(billId, entryType);
	}

}
