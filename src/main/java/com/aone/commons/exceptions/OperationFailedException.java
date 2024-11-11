package com.aone.commons.exceptions;

public class OperationFailedException extends RuntimeException {

	private static final long serialVersionUID = -6169307898855239809L;

	public OperationFailedException(String message) {
		super(message);
	}

	public OperationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationFailedException(Throwable cause) {
		super(cause);
	}

	protected OperationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
