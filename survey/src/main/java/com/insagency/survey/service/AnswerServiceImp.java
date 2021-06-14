package com.insagency.survey.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insagency.survey.entity.Answer;
import com.insagency.survey.entity.AnswerOutput;
import com.insagency.survey.entity.Survey;
import com.insagency.survey.repository.AnswerRepo;
import com.insagency.survey.repository.SurveyRepo;

@Service
public class AnswerServiceImp implements BaseService<Answer> {

	@Autowired
	private AnswerRepo answerRepo;

	@Autowired
	private SurveyRepo surveyRepo;

	@Autowired
	private SurveyServiceImp surveyService;

	@Override
	public Answer save(Answer entity) {
		Optional<Survey> survey = surveyService.getById(entity.getSurveyid());
		if (survey.isEmpty()||survey == null || survey.get() == null) {
			throw new RuntimeException("Answer has no assign by any Survey Topic!");

		} else if (entity.getScore() < 0 || entity.getScore() > 10) {
			throw new RuntimeException("Score is invalid!");
		}

		return answerRepo.save(entity);
	}
	
	@Override
	public Optional<Answer> getById(Long id) {
		
		return null;
	}

	
	public List<AnswerOutput> findAnswerTopic(String topic) {

		if (surveyRepo.findSurveyByTopic(topic).size() == 0) {
			throw new RuntimeException("Topic is not found!");
		}
		return answerRepo.findAnswerTopic(topic);
	}
	
}
