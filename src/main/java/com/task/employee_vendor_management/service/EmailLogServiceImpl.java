package com.task.employee_vendor_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.employee_vendor_management.entity.EmailLog;
import com.task.employee_vendor_management.repository.EmailLogRepository;


@Service
public class EmailLogServiceImpl implements EmailLogService{

	private final EmailLogRepository emailLogRepository;

    @Autowired
    public EmailLogServiceImpl(EmailLogRepository emailLogRepository) {
        this.emailLogRepository = emailLogRepository;
    }

    @Override
    public void logEmail(String toEmail, String subject, String body, boolean sentSuccessfully) {
        EmailLog emailLog = new EmailLog();
        emailLog.setToEmail(toEmail);
        emailLog.setSubject(subject);
        emailLog.setBody(body);
        emailLog.setSentSuccessfully(sentSuccessfully);

        emailLogRepository.save(emailLog);
    }

    @Override
    public List<EmailLog> getAllEmailLogs() {
        return emailLogRepository.findAll();
    }

}
