package com.aone.module.employee.dao.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.aone.corelibrary.dao.impl.AbstractBaseMasterRepository;
import com.aone.module.employee.dao.IEmployeeDao;
import com.aone.module.employee.model.EmployeeMaster;


@Lazy
@Repository("employeeDaoImpl")
public class EmployeeDaoImpl extends AbstractBaseMasterRepository<EmployeeMaster, Long> implements IEmployeeDao {

	@Override
	public Class<EmployeeMaster> getClazz() {
		return EmployeeMaster.class;
	}

}
