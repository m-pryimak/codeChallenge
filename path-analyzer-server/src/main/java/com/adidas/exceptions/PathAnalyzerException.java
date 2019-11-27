package com.adidas.exceptions;

public class PathAnalyzerException extends RuntimeException {

	private static final long serialVersionUID = -2844080813471994465L;
	private Throwable exception;
	private String message;

	public PathAnalyzerException(String message) {
		this.message = message;
	}

	public PathAnalyzerException(String message, Throwable ex) {
		this.message = message;
		this.exception = ex;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
