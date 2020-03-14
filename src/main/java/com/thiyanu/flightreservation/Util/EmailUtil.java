package com.thiyanu.flightreservation.Util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;



@Component
public class EmailUtil {
	@Value("${com.thiyanu.flightreservation.itenary.email.body}")
    private String EMAIL_BODY;
	@Value("${com.thiyanu.flightreservation.itenary.email.subject}")
    private String EMAIL_SUBJECT;
    
	@Autowired
	private JavaMailSender sender;
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

	
	public void sendIternary(String toAddress, String filepath) {
        LOGGER.info("Inside sendIternary()");

		MimeMessage message = sender.createMimeMessage();

		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setTo(toAddress);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			helper.addAttachment("Iternary", new File(filepath));
			sender.send(message);
		} catch (MessagingException e) {
	        LOGGER.error("Exception inside the sendIternary():"+e);

		
		}
		
		
	
	}
	
}
