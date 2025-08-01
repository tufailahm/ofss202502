package org.example;

public class InvalidWordException extends RuntimeException {

	public InvalidWordException() {

	}

	public InvalidWordException(String message, Throwable cause, boolean enableSuppression,
								boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidWordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidWordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidWordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
