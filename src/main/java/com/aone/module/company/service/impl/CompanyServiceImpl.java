package com.aone.module.company.service.impl;

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
import com.aone.module.company.dao.ICompanyDao;
import com.aone.module.company.model.Company;
import com.aone.module.company.service.ICompanyService;

@Lazy
@Service("companyServiceImpl")
public class CompanyServiceImpl extends AbstractBaseMasterService<Company, Long, ICompanyDao>
		implements ICompanyService {

	private ICompanyDao companyDao;

	@Override
	public ICompanyDao getRepository() {
		return getCompanyDao();
	}

	public ICompanyDao getCompanyDao() {
		return companyDao;
	}

	@Autowired
	@Qualifier(value = "companyDaoImpl")
	public void setCompanyDao(ICompanyDao companyDao) {
		this.companyDao = companyDao;
	}
	
	@Override
	public ResponseEntity<IResponseData<Boolean>> checkCompanyName(RequestData<Company, Long> requestData) {
		IResponseData<Boolean> responseData = new ResponseData<>(!getRepository().checkUniqueDataByField("name", requestData.getData().getName(), "id", requestData.getData().getId()).isEmpty(), ResultCodeConstant.SUCCESS);
		responseData.setRequestToken(requestData.getRequestToken());
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@Override
	public ResultCodeConstant validateData(Company company) {
		if(company == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		
		// validate name
		if(company.getName() == null || company.getName().isEmpty()) {
			return ResultCodeConstant.ITEM_COMPANY_NAME_NOT_FOUND;
		}
		// check if Company name already exist
		if(!getRepository().checkUniqueDataByField("name", company.getName(), "id", company.getId()).isEmpty()) {
			return ResultCodeConstant.ITEM_COMPANY_NAME_ALREADY_EXIST;
		}
		return ResultCodeConstant.SUCCESS;
	}

}
