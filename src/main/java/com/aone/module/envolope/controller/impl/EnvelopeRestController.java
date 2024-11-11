package com.aone.module.envolope.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.envolope.controller.IEnvelopeController;
import com.aone.module.envolope.model.Envelope;
import com.aone.module.envolope.service.IEnvelopeService;

@RestController
@RequestMapping("/rest/envelope")
public class EnvelopeRestController extends AbstractBaseMasterRestController<Envelope  , Long, IEnvelopeService > implements IEnvelopeController  {

	private IEnvelopeService envelopeService;
	
	@Override
	public IEnvelopeService getService() {
		return getEnvelopeService();
	}

	public IEnvelopeService getEnvelopeService() {
		return envelopeService;
	}

	@Autowired
	@Qualifier(value="envelopeServiceImpl")
	public void setEnvelopeService(IEnvelopeService envelopeService) {
		this.envelopeService = envelopeService;
	}

}
