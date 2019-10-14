package com.survey.surveyshrike.entity;

import java.io.Serializable;
import java.util.List;

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
 * The persistent class for the "survey_question_options" database table.
 * 
 */
@Entity
@Table(name = "\"survey_question_options\"")
@NamedQuery(name = "SurveyQuestionOption.findAll", query = "SELECT s FROM SurveyQuestionOption s")
public class SurveyQuestionOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"")
	private int id;

	@Column(name = "\"option_choice_name\"")
	private String optionChoiceName;

	// bi-directional many-to-one association to SurveyAnswer
	@OneToMany(mappedBy = "surveyQuestionOption")
	private List<SurveyAnswer> surveyAnswers;

	// bi-directional many-to-one association to SurveyQuestion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "questionId", referencedColumnName = "id", insertable = true, updatable = false)
	private SurveyQuestion surveyQuestion;

	public SurveyQuestionOption() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOptionChoiceName() {
		return this.optionChoiceName;
	}

	public void setOptionChoiceName(String optionChoiceName) {
		this.optionChoiceName = optionChoiceName;
	}

	public List<SurveyAnswer> getSurveyAnswers() {
		return this.surveyAnswers;
	}

	public void setSurveyAnswers(List<SurveyAnswer> surveyAnswers) {
		this.surveyAnswers = surveyAnswers;
	}

	public SurveyAnswer addSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().add(surveyAnswer);
		surveyAnswer.setSurveyQuestionOption(this);

		return surveyAnswer;
	}

	public SurveyAnswer removeSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().remove(surveyAnswer);
		surveyAnswer.setSurveyQuestionOption(null);

		return surveyAnswer;
	}

	public SurveyQuestion getSurveyQuestion() {
		return this.surveyQuestion;
	}

	public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

}