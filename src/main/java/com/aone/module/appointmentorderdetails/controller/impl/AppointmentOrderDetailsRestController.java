package com.aone.module.appointmentorderdetails.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.appointmentorderdetails.controller.IAppointmentOrderDetailsController;
import com.aone.module.appointmentorderdetails.model.AppointmentOrderDetails;
import com.aone.module.appointmentorderdetails.service.IAppointmentOrderDetailsService;

@RestController
@RequestMapping("/rest/appointmentorderdetails")
public class AppointmentOrderDetailsRestController extends AbstractBaseMasterRestController<AppointmentOrderDetails, Long, IAppointmentOrderDetailsService> implements IAppointmentOrderDetailsController{

	private IAppointmentOrderDetailsService appointmentService;
	
	public IAppointmentOrderDetailsService getAppointmentService() {
		return appointmentService;
	}

	@Autowired        
	@Qualifier(value="appointmentOrderDetailsServiceImpl")
	public void setAppointmentService(IAppointmentOrderDetailsService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@Override
	public IAppointmentOrderDetailsService getService() {
		return getAppointmentService();
	}
}
