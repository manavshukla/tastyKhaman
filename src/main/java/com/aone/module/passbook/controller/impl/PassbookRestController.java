package com.aone.module.passbook.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.passbook.controller.IPassbookController;
import com.aone.module.passbook.model.Passbook;
import com.aone.module.passbook.service.IPassbookService;

@RestController
@RequestMapping("/rest/passbook")
public class PassbookRestController extends AbstractBaseMasterRestController<Passbook, Long, IPassbookService> implements IPassbookController {

	private IPassbookService passbookService;
	
	@Override
	public IPassbookService getService() {
		return getPassbookService();
	}

	public IPassbookService getPassbookService() {
		return passbookService;
	}

	@Autowired
	@Qualifier(value="passbookServiceImpl")
	public void setPassbookService(IPassbookService passbookService) {
		this.passbookService = passbookService;
	}

}
