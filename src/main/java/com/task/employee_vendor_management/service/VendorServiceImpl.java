package com.task.employee_vendor_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employee_vendor_management.dto.VendorDto;
import com.task.employee_vendor_management.entity.VendorEntity;
import com.task.employee_vendor_management.repository.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@Autowired
	private MailService mailService;

	@Override
	public String createVendor(VendorDto dto) {
		try {
			vendorRepository.save(prepareVendor(dto));
			return "Vendor Saved Successfully";
		} catch (Exception e) {
			return "Some Error occurred Vendor is not saved";
		}
	}

	@Override
	public List<VendorEntity> getAllVendors() {
		return vendorRepository.findAll();
	}
	
	private VendorEntity prepareVendor(VendorDto dto) {
		VendorEntity vendorEntity = new VendorEntity();
		vendorEntity.setEmail(dto.getEmail());
		vendorEntity.setName(dto.getName());
		vendorEntity.setUpiId(dto.getUpiId());
		
		return vendorEntity;
	}

	@Override
	public String sendMailToVendors(List<String> names) {
		List<VendorEntity> vendors = vendorRepository.findByNameIn(names);
		for (VendorEntity vendor : vendors) {
            String emailBody = String.format("Sending payments to vendor %s at upi %s", vendor.getName(), vendor.getUpiId());
            return mailService.sendEmail(vendor.getEmail(), "Payment Notification", emailBody);
        }
		return null;
	}

}
