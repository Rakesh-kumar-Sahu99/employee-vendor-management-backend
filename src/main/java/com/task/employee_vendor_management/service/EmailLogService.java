package com.task.employee_vendor_management.service;

import java.util.List;

import com.task.employee_vendor_management.entity.EmailLog;

public interface EmailLogService {
	
	
	public void logEmail(String toEmail, String subject, String body, boolean sentSuccessfully);

	List<EmailLog> getAllEmailLogs();
}
