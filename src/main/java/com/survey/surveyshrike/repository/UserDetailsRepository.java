package com.survey.surveyshrike.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.surveyshrike.entity.UserDetail;

@Repository
@Transactional
public interface UserDetailsRepository extends JpaRepository<UserDetail, Long> {

	UserDetail findFirstById(long id);

	UserDetail findByEmail(String emailId);

	UserDetail findFirstByEmail(String email);

}
