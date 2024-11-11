package com.aone.module.gstRate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.gstRate.dao.IGstRateDao;
import com.aone.module.gstRate.model.GstRate;
import com.aone.module.gstRate.service.IGstRateService;

@Lazy
@Service("gstRateServiceImpl")
public class GstRateServiceImpl extends AbstractBaseMasterService<GstRate , Long, IGstRateDao > implements
		IGstRateService{
	
	private IGstRateDao gstRateDao;

	@Override
	public IGstRateDao getRepository() {
		return getGstRateDao();
	}

	public IGstRateDao getGstRateDao() {
		return gstRateDao;
	}

	@Autowired
	@Qualifier(value = "gstRateDaoImpl")
	public void setGstRateDao(IGstRateDao gstRateDao) {
		this.gstRateDao = gstRateDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<GstRate>> save(RequestData<GstRate,Long> requestData) {
		GstRate gstRate = requestData.getData();
		if(gstRate.getGstRatePer() > 0) {
			gstRate.setIgst(gstRate.getGstRatePer());
			gstRate.setCgst(gstRate.getGstRatePer() / 2);
			gstRate.setSgst(gstRate.getGstRatePer() / 2);
		}
		return super.save(requestData);
	}
	
	@Override
	public ResultCodeConstant validateData(GstRate gstRate) {
		if(gstRate == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate GST rate greater than zero
		if(gstRate.getGstRatePer() < 0) {
			return ResultCodeConstant.GST_RATE_GT_ZERO;
		}
		
		// check if uom name already exist
		if(!getRepository().checkUniqueDataByField("name", gstRate.getName(), "id", gstRate.getId()).isEmpty()) {
			return ResultCodeConstant.GST_RATE_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}
}