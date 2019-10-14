package com.survey.surveyshrike.model;

public class SurveyshrikeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int errorCode;

	private String errorMessage;
	
	public SurveyshrikeException(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
