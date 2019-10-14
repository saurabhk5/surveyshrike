/**
 * 
 */
package com.survey.surveyshrike.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.surveyshrike.entity.SurveyDetail;
import com.survey.surveyshrike.entity.SurveyQuestion;
import com.survey.surveyshrike.entity.SurveyQuestionOption;
import com.survey.surveyshrike.entity.UserDetail;
import com.survey.surveyshrike.model.Question;
import com.survey.surveyshrike.model.QuestionOption;
import com.survey.surveyshrike.model.Survey;
import com.survey.surveyshrike.repository.SurveyDetailRepository;
import com.survey.surveyshrike.service.SurveyDetailsService;
import com.survey.surveyshrike.service.UserDetailsService;

@Service
public class SurveyDetailsServiceImpl implements SurveyDetailsService {

	@Autowired
	SurveyDetailRepository surveyDetailRepository;

	@Autowired
	UserDetailsService userService;

	@Override
	public List<Survey> getAllSurveys() {

		List<SurveyDetail> allSurvey = surveyDetailRepository.findAll();

		List<Survey> surveyList = generateResponse(allSurvey);

		return surveyList;
	}

	@Override
	public void createSurvey(Survey survey, UserDetail userDetail) {

		SurveyDetail surveyDetail = new SurveyDetail();

		surveyDetail.setName(survey.getName());
		surveyDetail.setDescription(survey.getDescription());
		surveyDetail.setStartDate(survey.getStartDate());
		surveyDetail.setEndDate(survey.getEndDate());
		surveyDetail.setCreatedDate(new Date());
		surveyDetail.setIsactive(true);
		surveyDetail.setCreatedBy(userDetail.getId());

		List<SurveyQuestion> surveyQuestions = new ArrayList<>();

		for (Question ques : survey.getQuestion()) {

			SurveyQuestion question = new SurveyQuestion();
			List<SurveyQuestionOption> optionsList = new ArrayList<>();

			question.setQuestion(ques.getQuestion());
			question.setInputType(ques.getInputType());
			question.setAnswerRequired(ques.isAnswerRequired());
			question.setSurveyDetail(surveyDetail);

			for (QuestionOption opt : ques.getQuestionOption()) {
				SurveyQuestionOption options = new SurveyQuestionOption();
				options.setOptionChoiceName(opt.getOptionChoiceName());
				options.setSurveyQuestion(question);
				optionsList.add(options);

			}
			question.setSurveyQuestionOptions(optionsList);
			surveyQuestions.add(question);
		}

		surveyDetail.setSurveyQuestions(surveyQuestions);

		surveyDetailRepository.save(surveyDetail);

	}

	@Override
	public List<Survey> getSurveyByUser(String email) {
		List<SurveyDetail> allSurveyByUser = surveyDetailRepository
				.getSurveyDetailsByUserDetailEmail(email);

		List<Survey> surveyList = generateResponse(allSurveyByUser);

		return surveyList;
	}

	private List<Survey> generateResponse(List<SurveyDetail> allSurvey) {
		List<Survey> surveyList = new ArrayList<>();

		for (SurveyDetail surveyDetail : allSurvey) {

			Survey survey = new Survey();
			survey.setName(surveyDetail.getName());
			survey.setDescription(surveyDetail.getDescription());
			survey.setStartDate(surveyDetail.getStartDate());
			survey.setEndDate(surveyDetail.getEndDate());
			survey.setEmail(surveyDetail.getUserDetail().getEmail());

			List<Question> questionList = new ArrayList<>();

			for (SurveyQuestion surveyQuestion : surveyDetail.getSurveyQuestions()) {
				Question question = new Question();
				question.setQuestion(surveyQuestion.getQuestion());
				question.setInputType(surveyQuestion.getInputType());
				question.setAnswerRequired(surveyQuestion.getAnswerRequired());

				List<QuestionOption> questionOptionsList = new ArrayList<>();

				for (SurveyQuestionOption surveyQuestionOption : surveyQuestion
						.getSurveyQuestionOptions()) {
					QuestionOption questionOption = new QuestionOption();
					questionOption.setOptionChoiceName(
							surveyQuestionOption.getOptionChoiceName());
					questionOptionsList.add(questionOption);
				}
				question.setQuestionOption(questionOptionsList);
				questionList.add(question);
			}
			survey.setQuestion(questionList);
			surveyList.add(survey);
		}
		return surveyList;
	}

}
