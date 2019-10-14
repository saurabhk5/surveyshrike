package com.survey.surveyshrike.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the "survey_details" database table.
 * 
 */
@Entity
@Table(name = "\"survey_details\"")
@NamedQuery(name = "SurveyDetail.findAll", query = "SELECT s FROM SurveyDetail s")
public class SurveyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"")
	private int id;

	@Column(name = "\"created_by\"")
	private int createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"created_date\"")
	private Date createdDate;

	@Column(name = "\"description\"")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"end_date\"")
	private Date endDate;

	@Column(name = "\"isactive\"")
	private boolean isactive;

	@Column(name = "\"name\"")
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"start_date\"")
	private Date startDate;

	// bi-directional many-to-one association to UserDetail
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "createdBy", referencedColumnName = "id", insertable = false, updatable = false)
	private UserDetail userDetail;

	// bi-directional many-to-one association to SurveyQuestion
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "surveyDetail")
	private List<SurveyQuestion> surveyQuestions;

	public SurveyDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<SurveyQuestion> getSurveyQuestions() {
		return this.surveyQuestions;
	}

	public void setSurveyQuestions(List<SurveyQuestion> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
	}

	public SurveyQuestion addSurveyQuestion(SurveyQuestion surveyQuestion) {
		getSurveyQuestions().add(surveyQuestion);
		surveyQuestion.setSurveyDetail(this);

		return surveyQuestion;
	}

	public SurveyQuestion removeSurveyQuestion(SurveyQuestion surveyQuestion) {
		getSurveyQuestions().remove(surveyQuestion);
		surveyQuestion.setSurveyDetail(null);

		return surveyQuestion;
	}

}