package com.aone.module.deliveryMethod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.deliveryMethod.dao.IDeliveryMethodDao;
import com.aone.module.deliveryMethod.model.DeliveryMethod;
import com.aone.module.deliveryMethod.service.IDeliveryMethodService;

@Lazy
@Service("deliveryMethodServiceImpl")
public class DeliveryMethodServiceImpl extends AbstractBaseMasterService<DeliveryMethod, Long, IDeliveryMethodDao>
		implements IDeliveryMethodService {

	private IDeliveryMethodDao deliveryMethodDao;

	@Override
	public IDeliveryMethodDao getRepository() {
		return getDeliveryMethodDao();
	}

	public IDeliveryMethodDao getDeliveryMethodDao() {
		return deliveryMethodDao;
	}

	@Autowired
	@Qualifier(value = "deliveryMethodDaoImpl")
	public void setDeliveryMethodDao(IDeliveryMethodDao deliveryMethodDao) {
		this.deliveryMethodDao = deliveryMethodDao;
	}
	
}
