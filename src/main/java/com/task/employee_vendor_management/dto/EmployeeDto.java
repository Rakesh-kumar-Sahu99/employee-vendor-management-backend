package com.task.employee_vendor_management.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class EmployeeDto implements Serializable{
	
	private String name;
	
	private String designation;
	
	private String email;
	
	private Long CTC;

}
