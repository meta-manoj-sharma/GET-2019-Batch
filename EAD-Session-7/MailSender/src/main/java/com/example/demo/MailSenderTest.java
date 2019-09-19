package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MailSenderTest {

	@Test
	public void testSmtp() {
		 MailSender mailSender = new SmtpMailSender();
		 assertEquals("Send Smtp mail", mailSender.emailService());
	}
	@Test
	public void testMock() {
		 MailSender mailSender = new MockMailSender();
		 assertEquals("writing mail content", mailSender.emailService());
	}
	
	@Test
	public void testSmtpNegative() {
		 MailSender mailSender = new SmtpMailSender();
		 assertNotEquals("mail", mailSender.emailService());
	}
	@Test
	public void testMockNegative() {
		 MailSender mailSender = new MockMailSender();
		 assertNotEquals("content", mailSender.emailService());
	}
}
