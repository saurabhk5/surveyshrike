package com.survey.surveyshrike.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the "user_details" database table.
 * 
 */
@Entity
@Table(name = "\"user_details\"")
@NamedQuery(name = "UserDetail.findAll", query = "SELECT u FROM UserDetail u")
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id\"")
	private int id;

	@Column(name = "\"email\"")
	private String email;

	@Column(name = "\"isactive\"")
	private boolean isactive;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"last_login\"")
	private Date lastLogin;

	@Column(name = "\"name\"")
	private String name;

	// bi-directional many-to-one association to SurveyAnswer
	@OneToMany(mappedBy = "userDetail")
	private List<SurveyAnswer> surveyAnswers;

	// bi-directional many-to-one association to SurveyDetail
	@OneToMany(mappedBy = "userDetail")
	private List<SurveyDetail> surveyDetails;

	public UserDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsactive() {
		return this.isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SurveyAnswer> getSurveyAnswers() {
		return this.surveyAnswers;
	}

	public void setSurveyAnswers(List<SurveyAnswer> surveyAnswers) {
		this.surveyAnswers = surveyAnswers;
	}

	public SurveyAnswer addSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().add(surveyAnswer);
		surveyAnswer.setUserDetail(this);

		return surveyAnswer;
	}

	public SurveyAnswer removeSurveyAnswer(SurveyAnswer surveyAnswer) {
		getSurveyAnswers().remove(surveyAnswer);
		surveyAnswer.setUserDetail(null);

		return surveyAnswer;
	}

	public List<SurveyDetail> getSurveyDetails() {
		return this.surveyDetails;
	}

	public void setSurveyDetails(List<SurveyDetail> surveyDetails) {
		this.surveyDetails = surveyDetails;
	}

	public SurveyDetail addSurveyDetail(SurveyDetail surveyDetail) {
		getSurveyDetails().add(surveyDetail);
		surveyDetail.setUserDetail(this);

		return surveyDetail;
	}

	public SurveyDetail removeSurveyDetail(SurveyDetail surveyDetail) {
		getSurveyDetails().remove(surveyDetail);
		surveyDetail.setUserDetail(null);

		return surveyDetail;
	}

}