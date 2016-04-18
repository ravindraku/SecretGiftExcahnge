package com.exercise.gift.processor;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.scheduling.annotation.Async;

import com.exercise.gift.constant.GiftExchangeConstants;

/**
 * Email Processor class to process email
 * @author Ravindra Kumar
 *
 */
public class EmailProcessor {
	
	/**
	 * This is utility method to used for sending email
	 * @param from Person
	 * @param to   Person
	 * @return boolean
	 */
	@Async
	public boolean mailSender(String fromPerson, String toPerson) {
		boolean mailStatus = Boolean.TRUE;
		// Get the session object
		Properties props = new Properties();
		props.put(GiftExchangeConstants.SMTP_HOST_KEY, GiftExchangeConstants.SMTP_HOST_VALUE);
		props.put(GiftExchangeConstants.SMTP_FACTORY_PORT_KEY, GiftExchangeConstants.SMTP_FACTORY_PORT_VALUE);
		props.put(GiftExchangeConstants.SMTP_FACTORY_CLASS_KEY, GiftExchangeConstants.SMTP_FACTORY_CLASS_NAME);
		props.put(GiftExchangeConstants.SMTP_AUTH_KEY, GiftExchangeConstants.SMTP_AUTH_VALUE);
		props.put(GiftExchangeConstants.SMTP_PORT_KEY, GiftExchangeConstants.SMTP_PORT_VALUE);
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				//this can be improved and read pass a token for authentication or can have 
				return new PasswordAuthentication("ravindraku@example.com.com", "password"); 
			}
		});
		
		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromPerson));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toPerson));
			message.setSubject("Secret Gift Exchange");
			message.setText("Hello, Here is your secret gift notification !!  "); //mail compose message can be read from file

			// Send message
			Transport.send(message);

		} catch (MessagingException mex) {
			mailStatus = Boolean.FALSE;
		}
		return mailStatus;
	}

}
