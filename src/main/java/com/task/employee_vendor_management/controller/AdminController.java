package com.task.employee_vendor_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.employee_vendor_management.constants.MappingConstants;
import com.task.employee_vendor_management.dto.AdminDto;
import com.task.employee_vendor_management.dto.EmployeeDto;
import com.task.employee_vendor_management.dto.VendorDto;
import com.task.employee_vendor_management.entity.AdminEntity;
import com.task.employee_vendor_management.entity.EmailLog;
import com.task.employee_vendor_management.entity.EmployeeEntity;
import com.task.employee_vendor_management.entity.VendorEntity;
import com.task.employee_vendor_management.service.AdminService;
import com.task.employee_vendor_management.service.EmailLogService;
import com.task.employee_vendor_management.service.EmployeeService;
import com.task.employee_vendor_management.service.VendorService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
    private EmployeeService employeeService;
	
    @Autowired
    private VendorService vendorService;
    
    @Autowired 
    private AdminService adminService;
    
    @Autowired
    private EmailLogService emailLogService;

    @PostMapping(value = MappingConstants.CREATE_EMPLOYEE)
    public @ResponseBody String createEmployee(@RequestBody EmployeeDto employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping(value = MappingConstants.GET_ALL_EMPLOYEE)
    public @ResponseBody List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @PostMapping(value = MappingConstants.CRAEATE_VENDOR)
    public @ResponseBody String createVendor(@RequestBody VendorDto vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping(value = MappingConstants.GET_ALL_VENDORS)
    public @ResponseBody List<VendorEntity> getAllVendors() {
        return vendorService.getAllVendors();
    }
    
    @PostMapping(value = "/sendEmailsToVendors")
    public String sendmailToVendors(@RequestBody List<String> names) {
    	return vendorService.sendMailToVendors(names);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody AdminDto adminDto) {
        boolean isValidCredentials = adminService.validateCredentials(adminDto.getEmail(), adminDto.getPassword());
        if (isValidCredentials) {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
        }
    }
    
    @GetMapping("/email-logs")
    public List<EmailLog> getAllEmailLogs() {
        return emailLogService.getAllEmailLogs();
    }
}
