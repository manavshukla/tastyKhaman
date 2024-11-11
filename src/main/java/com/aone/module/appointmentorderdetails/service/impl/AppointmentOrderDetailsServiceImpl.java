package com.aone.module.appointmentorderdetails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.appointmentorderdetails.dao.IAppointmentOrderDetailsDao;
import com.aone.module.appointmentorderdetails.model.AppointmentOrderDetails;
import com.aone.module.appointmentorderdetails.service.IAppointmentOrderDetailsService;

@Lazy
@Service("appointmentOrderDetailsServiceImpl")
public class AppointmentOrderDetailsServiceImpl extends AbstractBaseMasterService<AppointmentOrderDetails, Long, IAppointmentOrderDetailsDao> implements IAppointmentOrderDetailsService{

	private IAppointmentOrderDetailsDao appointmentOrderDetailsDao;
	
	@Override
	public IAppointmentOrderDetailsDao getRepository() {
		return getappointmentOrderDetailsDao();
	}

	public IAppointmentOrderDetailsDao getappointmentOrderDetailsDao() {
		return appointmentOrderDetailsDao;
	}

	@Autowired
	@Qualifier(value = "appointmentOrderDetailsDaoImpl")
	public void setAppointmentOrderDetailsDao(IAppointmentOrderDetailsDao appointmentOrderDetailsDao) {
		this.appointmentOrderDetailsDao = appointmentOrderDetailsDao;
	}
	
	
	public ResultCodeConstant validateData(AppointmentOrderDetails appointmentOrderDetails) {
		if(appointmentOrderDetails == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		if(appointmentOrderDetails.getContactId() == 0) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_CONTACT_ID;
		}
		
		if(appointmentOrderDetails.getContactVehicleDetailsId() > 0) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_CONTACT_VEHICLE_DETAILS_ID;
		}
		
		if(appointmentOrderDetails.getCreatedById() == 0) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_CREATED_BY_ID;
		}
		
		if(appointmentOrderDetails.getDropDriverId() == 0) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_DROP_DRIVER_ID;
		}
		
		if(appointmentOrderDetails.getPickUpDriverId() == 0) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_DROP_DRIVER_ID;
		}
		
		if(appointmentOrderDetails.getSupervisorId() == 0) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_SUPERVISOR_ID;
		}
		
		if(appointmentOrderDetails.getDateTimeOfAppointment() == null || appointmentOrderDetails.getDateTimeOfAppointment().toString().isEmpty()) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_DATE_TIME_OF_APPT;
		}
		
		if(appointmentOrderDetails.getPickUpDateTime() == null || appointmentOrderDetails.getDropDateTime().toString().isEmpty()) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_DROP_DATE_TIME;
		}
		if(appointmentOrderDetails.getPickUpDateTime() == null || appointmentOrderDetails.getPickUpDateTime().toString().isEmpty()) {
			return ResultCodeConstant.APPOINTMENT_ORDER_DETAILS_PICKUP_DATE_TIME;
		}
		
		return ResultCodeConstant.SUCCESS;
	}
}