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

	/* // constructor injection with name 
	 * @Autowired 
	 * EmailController(MailSender smtpMailSender){ 
	 * this.mailSender = smtpMailSender; 
	 * }
	 */

	/* // constructor injection with qualifiers 
	 * @Autowired 
	 * EmailController(@Qualifier("smtp") MailSender mailSender){
	 * this.mailSender = mailSender; 
	 * }
	 */

	/* // constructor injection with dependency injection
	 * @Autowired 
	 * EmailController(MailSender mailSender){
	 * this.mailSender = mailSender; 
	 * }
	 */

	/* // setter injection with name 
	 * @Autowired 
	 * //@Qualifier("mockMailSender") 
	 * public void setMailSender(MailSender smtpMailSender){ 
	 * this.mailSender = smtpMailSender; 
	 * }
	 */
	/* // setter injection with qualifiers
	 * @Autowired
	 * @Qualifier("mockMailSender") 
	 * public void setMailSender(MailSendermailSender) { 
	 * this.mailSender = mailSender; 
	 * }
	 */
	//setter injection with dependency injection
	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	// method to get value from mail sender method and return it to server
	@GetMapping
	public String showEmail() {
		return mailSender.emailService();
	}

}
