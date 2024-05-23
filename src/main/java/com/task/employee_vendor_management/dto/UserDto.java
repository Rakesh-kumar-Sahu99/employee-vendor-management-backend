package com.task.employee_vendor_management.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable{
	
	private String name;
	
	private String email;
	
	private String password;

}
