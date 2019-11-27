package com.adidas.exceptions;

public class PathAnalyzerRestException {

	private Long timestamp;
	private String message;

	public PathAnalyzerRestException(Long timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
