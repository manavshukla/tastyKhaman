package com.aone.module.appointmentorderdetails.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.appointmentorderdetails.dao.IAppointmentOrderDetailsDao;
import com.aone.module.appointmentorderdetails.model.AppointmentOrderDetails;

@Lazy
@Repository("appointmentOrderDetailsDaoImpl")
public class AppointmentOrderDetailsDaoImpl extends AbstractBaseMasterRepository<AppointmentOrderDetails, Long> implements IAppointmentOrderDetailsDao{

	@Override
	public Class<AppointmentOrderDetails> getClazz() {
		return AppointmentOrderDetails.class;
	}

}
