package com.task.employee_vendor_management.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdminDto implements Serializable{

	private String email;
	
	private String password;
}
