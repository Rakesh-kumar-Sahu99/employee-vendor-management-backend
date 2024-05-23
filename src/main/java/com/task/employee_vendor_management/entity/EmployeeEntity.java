package com.task.employee_vendor_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_data")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private Long employeeId;
	
	@Column(name = "employee_name")
	private String name;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "ctc")
	private Long CTC;
}
