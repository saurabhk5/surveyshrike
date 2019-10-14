package com.survey.surveyshrike.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the "survey_answers" database table.
 * 
 */
@Entity
@Table(name = "\"survey_answers\"")
@NamedQuery(name = "SurveyAnswer.findAll", query = "SELECT s FROM SurveyAnswer s")
public class SurveyAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"")
	private int id;

	@Column(name = "\"answer_text\"")
	private String answerText;

	@Column(name = "\"answered_by\"")
	private int answeredBy;

	@Column(name = "\"isanswered\"")
	private boolean isanswered;

	@Column(name = "\"option_id\"")
	private int optionId;

	@Column(name = "\"question_id\"")
	private int questionId;

	// bi-directional many-to-one association to SurveyQuestionOption
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "optionId", referencedColumnName = "id", insertable = false, updatable = false)
	private SurveyQuestionOption surveyQuestionOption;

	// bi-directional many-to-one association to SurveyQuestion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "questionId", referencedColumnName = "id", insertable = false, updatable = false)
	private SurveyQuestion surveyQuestion;

	// bi-directional many-to-one association to UserDetail
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "answeredBy", referencedColumnName = "id", insertable = false, updatable = false)
	private UserDetail userDetail;

	public SurveyAnswer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswerText() {
		return this.answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public int getAnsweredBy() {
		return this.answeredBy;
	}

	public void setAnsweredBy(int answeredBy) {
		this.answeredBy = answeredBy;
	}

	public boolean getIsanswered() {
		return this.isanswered;
	}

	public void setIsanswered(boolean isanswered) {
		this.isanswered = isanswered;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public SurveyQuestionOption getSurveyQuestionOption() {
		return this.surveyQuestionOption;
	}

	public void setSurveyQuestionOption(SurveyQuestionOption surveyQuestionOption) {
		this.surveyQuestionOption = surveyQuestionOption;
	}

	public SurveyQuestion getSurveyQuestion() {
		return this.surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}