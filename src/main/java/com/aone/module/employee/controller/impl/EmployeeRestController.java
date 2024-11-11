package com.aone.module.employee.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aone.config.security.annotation.SecurityClassRole;
import com.aone.corelibrary.constant.SecurityRoleModule;
import com.aone.corelibrary.controller.impl.AbstractBaseMasterRestController;
import com.aone.module.employee.controller.IEmployeeController;
import com.aone.module.employee.model.EmployeeMaster;
import com.aone.module.employee.service.IEmployeeService;

@RestController
@RequestMapping("/rest/employeeMaster")
@SecurityClassRole(baseRoleName = SecurityRoleModule.EMPLOYEE_MASTER)
public class EmployeeRestController extends AbstractBaseMasterRestController<EmployeeMaster, Long, IEmployeeService> implements IEmployeeController{

	private IEmployeeService employeeService;
	
	@Override
	public IEmployeeService getService() {
		return getEmployeeService();
	}

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	@Autowired        
	@Qualifier(value="employeeServiceImpl")
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
