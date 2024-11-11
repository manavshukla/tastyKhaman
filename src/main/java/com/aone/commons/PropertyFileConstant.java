package com.aone.commons;

/**
 * The Enum PropertyFileConstant.
 *
 * @author Bharat on Jul 9, 2017
 */

public enum PropertyFileConstant {

	//***************************************
	//** 			mail constant		   **
	//***************************************
	/** The mail smtp host. */
	// default constant used by java
	MAIL_SMTP_HOST("mail.smtp.host"),
	MAIL_SMTP_SOCKETFACTORY_PORT("mail.smtp.socketFactory.port"),
	MAIL_SMTP_SOCKETFACTORY_CLASS("mail.smtp.socketFactory.class"),
	MAIL_SMTP_AUTH("mail.smtp.auth"),
	MAIL_SMTP_PORT("mail.smtp.port"),
	
	// custom constant used by application
	FROM_ID("mail.fromid"),
	FROM_PASSWORD("mail.fromPassword"),
	SUBJECT("mail.subject"),
	TO_ID("mail.toId"),
	
	//***************************************
	//** 			otp constant		   **
	//***************************************
	// used by application
	OTP_OTPFORMAT("otp.otpFormat"),
	OTP_IGNORECHARACTERS("otp.ignoreCharacters"),
	OTP_OTPGENMODE("otp.otpGenMode"),
	OTP_REUSECOUNT("otp.reuseCount"),
	OTP_VALIDITY_MINUTES("otp.validity.minutes"),
	OTP_BLOCK_COUNT("otp.block.count"),
	
	
	//***************************************
	//** 			Environment constant   **
	//***************************************
	ENV_PROD("env.prod")
	;
	
	/** The value. */
	private String value;
	
	/**
	 * Instantiates a new property file constant.
	 *
	 * @param value the value
	 */
	private PropertyFileConstant(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
}
