package com.survey.surveyshrike.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.surveyshrike.entity.SurveyAnswer;

@Repository
@Transactional
public interface SurveyAnswerRepository extends JpaRepository<SurveyAnswer, Long>{

	SurveyAnswer getSurveyAnswerByQuestionIdAndAnsweredBy(int questionId, int userId);
}
