package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//@Qualifier
//@Component

public class MockMailSender implements MailSender {

	public String emailService() {
		return "writing mail content";
	}
}