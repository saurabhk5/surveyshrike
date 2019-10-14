package com.survey.surveyshrike.model;

import java.util.List;

public class Answer {

	private int surveyId;
	
	private String email;
	
	private List<QuestionAnswered> questionsAnswered;

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<QuestionAnswered> getQuestionsAnswered() {
		return questionsAnswered;
	}

	public void setQuestionsAnswered(List<QuestionAnswered> questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}
	
}
