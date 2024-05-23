package com.task.employee_vendor_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.employee_vendor_management.entity.VendorEntity;

public interface VendorRepository extends JpaRepository<VendorEntity, Long>{
	
	List<VendorEntity> findByNameIn(List<String> names);

}
