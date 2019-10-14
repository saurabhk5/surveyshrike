package com.survey.surveyshrike.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.survey.surveyshrike.model.Survey;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootSurveyShrikeApplicationTests {

	@LocalServerPort
	int randomServerPort;

	@Test
	public void testAllSurveys() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort
				+ "/surveyShrike/getAllSurvey";

		ResponseEntity<List<Survey>> result = restTemplate.exchange(baseUrl,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Survey>>() {
				});

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());

		List<Survey> response = result.getBody();
		assertThat(response).allMatch(d -> d.getEmail().equals("saurabh5oct@gmail.com"));

	}

	@Test
	public void testSurveyDetailsByUser() throws URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomServerPort
				+ "/surveyShrike/getSurveyByUser?email=saurabh5oct@gmail.com";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
	}

}
