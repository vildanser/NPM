package com.insagency.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insagency.survey.entity.Answer;
import com.insagency.survey.entity.AnswerOutput;
import com.insagency.survey.service.AnswerServiceImp;
import com.insagency.survey.service.SurveyServiceImp;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerServiceImp answerServisImp;

	@Autowired
	SurveyServiceImp surveyService;
	String responseCode = null;
	String responseMessage = null;

	
	@RequestMapping(value = "/submitAnswer", method = RequestMethod.POST)
	public Response submitAnswer(@RequestBody Answer answer) {
		try {
			Answer ans = answerServisImp.save(answer);
			responseCode = "200";
			responseMessage = "Success";
			return new Response(responseCode, responseMessage, ans);
		} catch (Exception e) {
			responseCode = "500";
			responseMessage = e.getMessage();
			return new Response(responseCode, responseMessage, null);
		}

	}


	@GetMapping("/listAnswer/{topic}")
	public Response listAnswersByTopic(@PathVariable String topic) {
		
		try {
			List<AnswerOutput> answerList=answerServisImp.findAnswerTopic(topic);
			responseCode = "200";
			responseMessage = "Success";
			return new Response(responseCode, responseMessage, answerList);
		} catch (Exception e) {
			responseCode = "500";
			responseMessage = e.getMessage();
			return new Response(responseCode, responseMessage, null);
		}
	}

}
