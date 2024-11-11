package com.aone.module.billOfMaterialDetail.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.billOfMaterialDetail.controller.IBillOfMaterialDetailController;
import com.aone.module.billOfMaterialDetail.model.BillOfMaterialDetail;
import com.aone.module.billOfMaterialDetail.service.IBillOfMaterialDetailService;

@RestController
@RequestMapping("/rest/billOfMaterialDetail")
public class BillOfMaterialDetailRestController extends AbstractBaseMasterRestController<BillOfMaterialDetail, Long, IBillOfMaterialDetailService> implements IBillOfMaterialDetailController {

	private IBillOfMaterialDetailService billOfMaterialDetailService;
	
	@Override
	public IBillOfMaterialDetailService getService() {
		return getBillOfMaterialDetailService();
	}

	public IBillOfMaterialDetailService getBillOfMaterialDetailService() {
		return billOfMaterialDetailService;
	}

	@Autowired
	@Qualifier(value="billOfMaterialDetailServiceImpl")
	public void setBillOfMaterialDetailService(
			IBillOfMaterialDetailService billOfMaterialDetailService) {
		this.billOfMaterialDetailService = billOfMaterialDetailService;
	}
}
