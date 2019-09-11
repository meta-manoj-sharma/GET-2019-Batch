package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EmailConfiguration {

	@Bean
	// @Qualifier("smtp")
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}

	@Bean
	@Primary
	// @Qualifier("mock")
	public MailSender mockMailSender() {
		return new MockMailSender();

	}
}
