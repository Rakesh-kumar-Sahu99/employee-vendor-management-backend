package com.task.employee_vendor_management.service;

import java.util.List;

import com.task.employee_vendor_management.dto.EmployeeDto;
import com.task.employee_vendor_management.entity.EmployeeEntity;

public interface EmployeeService {
	
	public List<EmployeeEntity> getAllEmployees() ;
	
	public String createEmployee(EmployeeDto employee);

}
