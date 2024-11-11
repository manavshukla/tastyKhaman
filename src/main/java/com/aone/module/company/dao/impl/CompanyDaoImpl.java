package com.aone.module.company.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.company.dao.ICompanyDao;
import com.aone.module.company.model.Company;

@Lazy
@Repository("companyDaoImpl")
public class CompanyDaoImpl extends AbstractBaseMasterRepository<Company, Long> implements ICompanyDao {

	@Override
	public Class<Company> getClazz() {
		return Company.class;
	}

}
