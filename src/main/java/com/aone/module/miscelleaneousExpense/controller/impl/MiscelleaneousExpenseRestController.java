package com.aone.module.miscelleaneousExpense.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.miscelleaneousExpense.controller.IMiscelleaneousExpenseController;
import com.aone.module.miscelleaneousExpense.model.MiscelleaneousExpense;
import com.aone.module.miscelleaneousExpense.service.IMiscelleaneousExpenseService;

@RestController
@RequestMapping("/rest/miscelleaneousExpense")
public class MiscelleaneousExpenseRestController extends AbstractBaseMasterRestController<MiscelleaneousExpense, Long, IMiscelleaneousExpenseService> implements IMiscelleaneousExpenseController {
	
	private IMiscelleaneousExpenseService miscelleaneousExpenseService;
	
	@Override
	public IMiscelleaneousExpenseService getService() {
		return getMiscelleaneousExpenseService();
	}

	public IMiscelleaneousExpenseService getMiscelleaneousExpenseService() {
		return miscelleaneousExpenseService;
	}

	@Autowired        
	@Qualifier(value="miscelleaneousExpenseServiceImpl")
	public void setMiscelleaneousExpenseService(
			IMiscelleaneousExpenseService miscelleaneousExpenseService) {
		this.miscelleaneousExpenseService = miscelleaneousExpenseService;
	}
}
