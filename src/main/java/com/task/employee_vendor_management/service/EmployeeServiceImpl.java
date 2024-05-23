package com.task.employee_vendor_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employee_vendor_management.dto.EmployeeDto;
import com.task.employee_vendor_management.entity.EmployeeEntity;
import com.task.employee_vendor_management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public String createEmployee(EmployeeDto employee) {
		try {
			employeeRepository.save(prepareEmployee(employee));
			return "Employee Saved Successfully";
		} catch (Exception e) {
			return "Some Error occurred Employee is not saved";
		} 
	}

	private EmployeeEntity prepareEmployee(EmployeeDto employeeDto) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setName(employeeDto.getName());
		employeeEntity.setDesignation(employeeDto.getDesignation());
		employeeEntity.setCTC(employeeDto.getCTC());
		employeeEntity.setEmail(employeeDto.getEmail());

		return employeeEntity;
	}

}
