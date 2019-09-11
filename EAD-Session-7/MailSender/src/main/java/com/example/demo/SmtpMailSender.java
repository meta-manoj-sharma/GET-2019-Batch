package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//@Primary
//@Qualifier
//@Component
public class SmtpMailSender implements MailSender {


	public String emailService() {
		return "Send Smtp mail";
	}
}