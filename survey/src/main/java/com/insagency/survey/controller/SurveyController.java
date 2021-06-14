package com.insagency.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.insagency.survey.entity.Survey;
import com.insagency.survey.entity.Topic;
import com.insagency.survey.service.SurveyServiceImp;

@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private SurveyServiceImp surveyService;
	
	String responseCode = null;
	String responseMessage = null;

	@RequestMapping(value = "/createSurvey", method = RequestMethod.POST)
	public Response create(@RequestBody Survey entity) {

		try {
			Survey survey = (Survey) surveyService.save(entity);
			responseCode = "200";
			responseMessage = "Success";
			return new Response(responseCode, responseMessage, survey);
		} catch (Exception e) {
			responseCode = "500";
			responseMessage = e.getMessage();
			return new Response(responseCode, responseMessage, null);
		}

	}

	@GetMapping(value = "/listSurveyTopicWithNPM")
	public Response listSurveyTopicsWithNPM() {

		try {
			List<Topic> response = (List<Topic>) surveyService.calculateNpm();
			responseCode = "200";
			responseMessage = "Success";
			return new Response(responseCode, responseMessage, response);
		} catch (Exception e) {
			responseCode = "500";
			responseMessage = e.getMessage();
			return new Response(responseCode, responseMessage, null);
		}
		

		

	}

}
