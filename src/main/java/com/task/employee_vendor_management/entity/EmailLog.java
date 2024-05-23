package com.task.employee_vendor_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "email_logs") // Define the name of the table
public class EmailLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_email")
    private String toEmail;

    private String subject;
    private String body;

    @Column(name = "sent_successfully")
    private boolean sentSuccessfully;
}

