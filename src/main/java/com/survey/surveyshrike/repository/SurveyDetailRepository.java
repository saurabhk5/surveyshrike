package com.survey.surveyshrike.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.surveyshrike.entity.SurveyDetail;

@Repository
@Transactional
public interface SurveyDetailRepository extends JpaRepository<SurveyDetail, Long> {

	List<SurveyDetail> getSurveyDetailsByUserDetailEmail(String email);
	
	SurveyDetail getSurveyDetailsById(int surveyId);

}
