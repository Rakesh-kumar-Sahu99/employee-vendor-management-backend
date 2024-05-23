package com.task.employee_vendor_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employee_vendor_management.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public boolean validateCredentials(String email, String password) {
		String actualPassword = adminRepository.getAdminCredentials(email);
        return actualPassword != null && actualPassword.equals(password);
	}

}
