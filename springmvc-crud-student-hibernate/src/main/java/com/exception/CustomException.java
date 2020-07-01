package com.exception;

public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String rootCause;

	public CustomException(Exception ex) {
		super();
		this.errorMessage = ex.getMessage();
		if (ex.getCause() != null) {
			this.rootCause = ex.getCause().getMessage();
		}
	}

	public CustomException(String errorMessage, String rootCause) {
		super();
		this.errorMessage = errorMessage;
		this.rootCause = rootCause;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

}
