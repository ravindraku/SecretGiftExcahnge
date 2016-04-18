package com.exercise.gift.constant;

public interface GiftExchangeConstants {
	
	public static final String SPACE = " ";
	
	//SMPT key properties
	public static final String SMTP_HOST_KEY = "mail.smtp.host";
	public static final String SMTP_FACTORY_PORT_KEY = "mail.smtp.socketFactory.port";
	public static final String SMTP_FACTORY_CLASS_KEY = "mail.smtp.socketFactory.class";
	public static final String SMTP_AUTH_KEY = "mail.smtp.auth";
	public static final String SMTP_PORT_KEY = "mail.smtp.port";
	
	//SMTP exercise value
	public static final String SMTP_HOST_VALUE = "smtp.gmail.com";
	public static final String SMTP_FACTORY_PORT_VALUE = "465";
	public static final String SMTP_FACTORY_CLASS_NAME = "javax.net.ssl.SSLSocketFactory";
	public static final String SMTP_AUTH_VALUE = "true";
	public static final String SMTP_PORT_VALUE = "465";
	
	public static final String TEST_EMAIL = "ravindra@gmail.com"; //this needs to be valid smtp email
	public static final String TEST_EMAIL_PASSWORD = "Vajir24o"; //this needs to be valid email password
	public static final String EMAIL_SUBJECT = "Secret Gift Exchange";
	public static final String EMAIL_BODY = "Hello, Here is your secret gift notification !!";
	
	public static final String PROPERTY_FILE_NAME = "config.properties";
	

}
