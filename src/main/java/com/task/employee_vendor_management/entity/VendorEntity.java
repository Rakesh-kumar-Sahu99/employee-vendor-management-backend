package com.task.employee_vendor_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vendor_data")
public class VendorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	private Long id;
	
	@Column(name = "vendor_name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "upi_id")
	private String upiId;

}
