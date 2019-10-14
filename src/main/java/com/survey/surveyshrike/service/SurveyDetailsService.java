/**
 * 
 */
package com.survey.surveyshrike.service;

import java.util.List;

import com.survey.surveyshrike.entity.UserDetail;
import com.survey.surveyshrike.model.Survey;

public interface SurveyDetailsService {

	List<Survey> getAllSurveys();

	void createSurvey(Survey survey, UserDetail userDetail);

	List<Survey> getSurveyByUser(String email);

}
