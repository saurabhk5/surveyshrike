package com.survey.surveyshrike.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.surveyshrike.entity.UserDetail;
import com.survey.surveyshrike.model.UserInfo;
import com.survey.surveyshrike.repository.UserDetailsRepository;
import com.survey.surveyshrike.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public UserDetail findUserById(Long id) {
		return userDetailsRepository.findFirstById(id);
	}

	@Override
	public void createUser(UserInfo userInfo) {

		UserDetail userDetail = new UserDetail();
		userDetail.setName(userInfo.getName());
		userDetail.setEmail(userInfo.getEmail());
		userDetail.setIsactive(true);
		userDetail.setLastLogin(new Date());

		userDetailsRepository.save(userDetail);
	}

	@Override
	public UserDetail findUserByEmail(String email) {
		return userDetailsRepository.findFirstByEmail(email);
	}

}
