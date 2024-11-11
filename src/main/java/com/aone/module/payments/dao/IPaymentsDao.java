package com.aone.module.payments.dao;

import java.util.List;

import com.aone.corelibrary.dao.IBaseMasterRepository;
import com.aone.module.payments.constant.PaymentConstant;
import com.aone.module.payments.model.PaymentsMaster;

public interface IPaymentsDao extends IBaseMasterRepository<PaymentsMaster, Long> {

	public List<PaymentsMaster> getListByTransType(PaymentConstant paymentConstant, long contactId);

	public int deleteByBillId(long billId, String entryType);

}
