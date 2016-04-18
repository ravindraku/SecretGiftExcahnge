package com.exercise.gift.processor;

import org.junit.Assert;
import org.junit.Test;

import com.exercise.gift.processor.EmailProcessor;

public class SendEmailTest {
	
	private EmailProcessor sendEmail = null;

	@Test
	public void testMailSender() {
		 sendEmail = new EmailProcessor();
		 boolean status = sendEmail.mailSender("from@gmail.com","to@gmail.com");
		 
		 //@TODO following line needs to uncommented to test send email
		 //Assert.assertTrue(status);
	}

}