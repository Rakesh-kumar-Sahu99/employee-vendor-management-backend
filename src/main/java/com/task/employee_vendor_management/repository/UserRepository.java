package com.task.employee_vendor_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.employee_vendor_management.entity.EmployeeEntity;

public interface UserRepository extends JpaRepository<EmployeeEntity, Long>{

}
