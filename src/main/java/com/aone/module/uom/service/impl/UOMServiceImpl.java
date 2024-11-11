package com.aone.module.uom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.corelibrary.model.impl.ResponseData;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.uom.dao.IUOMDao;
import com.aone.module.uom.model.UOM;
import com.aone.module.uom.service.IUOMService;

@Lazy
@Service("uomServiceImpl")
public class UOMServiceImpl extends AbstractBaseMasterService<UOM, Long, IUOMDao> implements
		IUOMService {
	
	private IUOMDao uomDao;

	@Override
	public IUOMDao getRepository() {
		return getUomDao();
	}

	/**
	 * @return the uomDao
	 */
	public IUOMDao getUomDao() {
		return uomDao;
	}

	/**
	 * @param uomDao the uomDao to set
	 */
	@Autowired
	@Qualifier(value = "uomDaoImpl")
	public void setUomDao(IUOMDao uomDao) {
		this.uomDao = uomDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkUOMName(RequestData<UOM, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(UOM uom) {
		if(uom == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(uom.getName() == null || uom.getName().isEmpty()) {
			return ResultCodeConstant.UOM_NAME_NOT_FOUND;
		}
		// check if uom name already exist
		if(!getRepository().checkUniqueDataByField("name", uom.getName(), "id", uom.getId()).isEmpty()) {
			return ResultCodeConstant.UOM_NAME_ALREADY_EXIST;
		}
		
		return ResultCodeConstant.SUCCESS;
	}
}
