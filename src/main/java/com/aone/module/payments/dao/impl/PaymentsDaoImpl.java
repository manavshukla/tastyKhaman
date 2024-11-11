package com.aone.module.payments.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.payments.constant.PaymentConstant;
import com.aone.module.payments.dao.IPaymentsDao;
import com.aone.module.payments.model.PaymentsMaster;

@Lazy
@Repository("paymentsDaoImpl")
public class PaymentsDaoImpl extends AbstractBaseMasterRepository<PaymentsMaster, Long> implements IPaymentsDao {

	@Override
	public Class<PaymentsMaster> getClazz() {
		return PaymentsMaster.class;
	}
	
	@Override
	public List<PaymentsMaster> getListByTransType(PaymentConstant paymentConstant, long contactId){
		Map<String, Object> params  = new HashMap<>();
		params.put("deleted", false);
		params.put("creditDebitFlag", paymentConstant.getValue());
		params.put("contactId", contactId);
		return super.getByQueryData(params, new HashMap<>());
	}
	
	@Override
	@Transactional(readOnly = false)
	public int deleteByBillId(long billId, String entryType) {
		StringBuilder queryBuilder = new StringBuilder(70);
		queryBuilder.append("UPDATE ");
		queryBuilder.append(getClazz().getName());
		queryBuilder.append(" SET deleted = :deleted ");
		queryBuilder.append(" WHERE billId = :billId");
		queryBuilder.append(" AND entryType = :entryType");
		queryBuilder.append(" AND systemGenerated = :systemGenerated");
		Query query = getEntityManager().createQuery(queryBuilder.toString());
		query.setParameter("entryType", entryType);
		query.setParameter("billId", billId);
		query.setParameter("deleted", true);
		query.setParameter("systemGenerated", true);
		return query.executeUpdate();
	}

}
