package com.task.employee_vendor_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.employee_vendor_management.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long>{
	
	@Query("SELECT a.password FROM AdminEntity a WHERE a.email = :email")
	public String getAdminCredentials(String email);

}
