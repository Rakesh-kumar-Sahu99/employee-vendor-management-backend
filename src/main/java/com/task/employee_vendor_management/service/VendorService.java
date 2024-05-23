package com.task.employee_vendor_management.service;

import java.util.List;

import com.task.employee_vendor_management.dto.VendorDto;
import com.task.employee_vendor_management.entity.VendorEntity;

public interface VendorService {
	
	public String createVendor(VendorDto dto);
	
	public List<VendorEntity> getAllVendors();
	
	 public String sendMailToVendors(List<String> names);

}
