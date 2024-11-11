package com.aone.module.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.service.impl.AbstractBaseMasterService;
import com.aone.module.employee.dao.IEmployeeDao;
import com.aone.module.employee.model.EmployeeMaster;
import com.aone.module.employee.service.IEmployeeService;

@Lazy
@Service("employeeServiceImpl")
public class EmployeeServiceImpl extends AbstractBaseMasterService<EmployeeMaster, Long, IEmployeeDao> implements IEmployeeService {

	private IEmployeeDao employeeDao;
	
	@Override
	public IEmployeeDao getRepository() {
		return getEmployeeDao();
	}

	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	@Autowired
	@Qualifier(value = "employeeDaoImpl")
	public void setServicesDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	public ResultCodeConstant validateData(EmployeeMaster employee) {
		if(employee == null) {
			return ResultCodeConstant.PARAMETER_NOT_FOUND;
		}
		// validate name
				if(employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
					return ResultCodeConstant.EMPLOYEE_FIRST_NAME;
				}
				if(employee.getLastName() == null || employee.getLastName().isEmpty()) {
					return ResultCodeConstant.EMPLOYEE_LAST_NAME;
				}
				if(!getRepository().checkUniqueDataByField("firstName", employee.getFirstName(), "id", employee.getId()).isEmpty()) {	
					if(!getRepository().checkUniqueDataByField("lastName", employee.getFirstName(), "id", employee.getId()).isEmpty()) {
						if(!getRepository().checkUniqueDataByField("middleName", employee.getFirstName(), "id", employee.getId()).isEmpty()) {
							return ResultCodeConstant.EMPLOYEE_MIDDLE_NAME;	
						}
						return ResultCodeConstant.EMPLOYEE_LAST_NAME;
					}
					return ResultCodeConstant.EMPLOYEE_FIRST_NAME;
				}
				
				if(employee.getAddress1() == null || employee.getAddress1().isEmpty()) {
					return ResultCodeConstant.EMPLOYEE_ADDRESS_1;
				}
				if(employee.getDateOfBirth() == null || employee.getDateOfBirth().toString().isEmpty()) {
					return ResultCodeConstant.EMPLOYEE_DATE_OF_BIRTH;
				}
				
				return ResultCodeConstant.SUCCESS;
	}
}