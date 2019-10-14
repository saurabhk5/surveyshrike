package com.survey.surveyshrike.service;

import com.survey.surveyshrike.entity.UserDetail;
import com.survey.surveyshrike.model.UserInfo;

public interface UserDetailsService {

	UserDetail findUserById(Long Id);

	UserDetail findUserByEmail(String email);

	void createUser(UserInfo userInfo);

}
