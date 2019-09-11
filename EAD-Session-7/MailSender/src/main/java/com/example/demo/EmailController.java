package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * controller for mailsender 
 * @author Manoj Sharma
 * Dated 11 sept. 2019
 */
@RestController
@RequestMapping("/email")
public class EmailController {
	private MailSender mailSender;

	/*
	 * @Autowired 
	 * EmailController(MailSender smtpMailSender){ 
	 * this.mailSender = smtpMailSender; 
	 * }
	 */

	/*
	 * @Autowired 
	 * EmailController(@Qualifier("smtp") MailSender mailSender){
	 * this.mailSender = mailSender; 
	 * }
	 */

	/*
	 * @Autowired 
	 * EmailController(MailSender mailSender){
	 * this.mailSender = mailSender; 
	 * }
	 */

	/*
	 * @Autowired 
	 * //@Qualifier("mockMailSender") 
	 * public void setMailSender(MailSender smtpMailSender){ 
	 * this.mailSender = smtpMailSender; 
	 * }
	 */
	/*
	 * @Autowired
	 * @Qualifier("mockMailSender") 
	 * public void setMailSender(MailSendermailSender) { 
	 * this.mailSender = mailSender; 
	 * }
	 */
	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@GetMapping
	public String showEmail() {
		return mailSender.emailService();
	}

}
