package com.survey.surveyshrike.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the "survey_questions" database table.
 * 
 */
@Entity
@Table(name = "\"survey_questions\"")
@NamedQuery(name = "SurveyQuestion.findAll", query = "SELECT s FROM SurveyQuestion s")
public class SurveyQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"")
	private int id;

	@Column(name = "\"answer_required\"")
	private boolean answerRequired;

	@Column(name = "\"input_type\"")
	private int inputType;

	@Column(name = "\"question\"")
	private String question;

	// bi-directional many-to-one association to SurveyAnswer
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "surveyQuestion")
	private List<SurveyAnswer> surveyAnswers;

	// bi-directional many-to-one association to SurveyQuestionOption
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "surveyQuestion")
	private List<SurveyQuestionOption> surveyQuestionOptions;

	// bi-directional many-to-one association to SurveyDetail
	@ManyToOne(cascade= CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "surveyId", referencedColumnName = "id"/*, nullable = false, insertable = true, updatable = false*/)
	private SurveyDetail surveyDetail;

	// bi-directional many-to-one association to SurveyInputType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inputType", referencedColumnName = "id", insertable = false, updatable = false)
	private SurveyInputType surveyInputType;

	public SurveyQuestion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAnswerRequired() {
		return this.answerRequired;
	}

	public void setAnswerRequired(boolean answerRequired) {
		this.answerRequired = answerRequired;
	}

	public int getInputType() {
		return this.inputType;
	}

	public void setInputType(int inputType) {
		this.inputType = inputType;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<SurveyAnswer> getSurveyAnswers() {
		return this.surveyAnswers;
	}

	public void setSurveyAnswers(List<SurveyAnswer> surveyAnswers) {
		this.surveyAnswers = surveyAnswers;
	}

	public SurveyAnswer addSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().add(surveyAnswer);
		surveyAnswer.setSurveyQuestion(this);

		return surveyAnswer;
	}

	public SurveyAnswer removeSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().remove(surveyAnswer);
		surveyAnswer.setSurveyQuestion(null);

		return surveyAnswer;
	}

	public List<SurveyQuestionOption> getSurveyQuestionOptions() {
		return this.surveyQuestionOptions;
	}

	public void setSurveyQuestionOptions(
			List<SurveyQuestionOption> surveyQuestionOptions) {
		this.surveyQuestionOptions = surveyQuestionOptions;
	}

	public SurveyQuestionOption addSurveyQuestionOption(
			SurveyQuestionOption surveyQuestionOption) {
		getSurveyQuestionOptions().add(surveyQuestionOption);
		surveyQuestionOption.setSurveyQuestion(this);

		return surveyQuestionOption;
	}

	public SurveyQuestionOption removeSurveyQuestionOption(
			SurveyQuestionOption surveyQuestionOption) {
		getSurveyQuestionOptions().remove(surveyQuestionOption);
		surveyQuestionOption.setSurveyQuestion(null);

		return surveyQuestionOption;
	}

	public SurveyDetail getSurveyDetail() {
		return this.surveyDetail;
	}

	public void setSurveyDetail(SurveyDetail surveyDetail) {
		this.surveyDetail = surveyDetail;
	}

	public SurveyInputType getSurveyInputType() {
		return this.surveyInputType;
	}

	public void setSurveyInputType(SurveyInputType surveyInputType) {
		this.surveyInputType = surveyInputType;
	}

}