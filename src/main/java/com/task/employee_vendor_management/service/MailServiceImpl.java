package com.task.employee_vendor_management.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class MailServiceImpl implements MailService{
	
	@Value("${spring.sendgrid.api-key}")
    private String sendGridApiKey;
	
	private final EmailLogService emailLogService;

    @Autowired
    public MailServiceImpl(EmailLogService emailLogService) {
        this.emailLogService = emailLogService;
    }


	@Override
	public String sendEmail(String to, String subject, String body) {
	    Email from = new Email("rakesh.sahu00@outlook.com");
	    Email toEmail = new Email(to);
	    Content content = new Content("text/plain", body);
	    Mail mail = new Mail(from, subject, toEmail, content);

	    SendGrid sg = new SendGrid(sendGridApiKey);
	    Request request = new Request();

	    try {
	        request.setMethod(Method.POST);
	        request.setEndpoint("mail/send");
	        request.setBody(mail.build());
	        Response response = sg.api(request);
	        
	        boolean sentSuccessfully = response.getStatusCode() == 202;
            emailLogService.logEmail(to, subject, body, sentSuccessfully);

	        if (sentSuccessfully) {
	            return "Mail sent successfully";
	        } else {
	            System.out.println("SendGrid error response: " + response.getBody());
	            return "Failed to send mail";
	        }

	    } catch (IOException ex) {
	        ex.printStackTrace();
	        return "Error sending mail: " + ex.getMessage();
	    }
	}


}
