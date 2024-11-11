package com.aone.corelibrary.constant;

public enum ExceptionMessage {
	
	PARAMTER_NOT_FOUND("The #%$@! must not be null!"),
	;

	private String message;

	private ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage(String fieldName) {
		return message.replace("#%$@!", fieldName);
	}
	
}
