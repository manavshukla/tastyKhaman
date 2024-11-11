package com.aone.module.deliveryMethod.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.deliveryMethod.dao.IDeliveryMethodDao;
import com.aone.module.deliveryMethod.model.DeliveryMethod;

@Lazy
@Repository("deliveryMethodDaoImpl")
public class DeliveryMethodDaoImpl extends AbstractBaseMasterRepository<DeliveryMethod, Long> implements IDeliveryMethodDao  {

	@Override
	public Class<DeliveryMethod> getClazz() {
		return DeliveryMethod.class;
	}

}
