package com.insagency.survey.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insagency.survey.entity.Answer;
import com.insagency.survey.entity.Survey;
import com.insagency.survey.entity.Topic;
import com.insagency.survey.repository.AnswerRepo;
import com.insagency.survey.repository.SurveyRepo;

@Service
public class SurveyServiceImp implements BaseService<Survey> {

	@Autowired
	private SurveyRepo surveyRepo;

	@Autowired
	private AnswerRepo answerRepo;

	@Override
	public Survey save(Survey entity) {

		if (entity.getNpmscore() != 0) {
			throw new RuntimeException("You can't set NpmScore!");
		}
		if (surveyRepo.findSurveyByTopic(entity.getTopic()).size() > 0) {
			throw new RuntimeException("Survey has already created!");
		}

		return surveyRepo.save(entity);
	}

	@Override
	public Optional<Survey> getById(Long id) {
         
		  return  surveyRepo.findById(id);
	}

	public List<Topic> calculateNpm() {

		List<Survey> surveys = surveyRepo.findAll();
		List<Topic> topics = new ArrayList<Topic>();
		for (Survey survey : surveys) {
			Topic topic = new Topic();
			List<Answer> answers = answerRepo.findAllBySurveyid(survey.getId());
			int promoterCount = 0;
			int detractorCount = 0;
			for (Answer answer : answers) {
				if (answer.getScore() >= 9) {
					promoterCount++;
				} else if (answer.getScore() <= 6) {
					detractorCount++;
				}
			}

			int npmScore = (int) (100 * ((float) (promoterCount - detractorCount) / answers.size()));

			survey.setNpmscore(Long.valueOf(npmScore));
			surveyRepo.save(survey);
			topic.setId(survey.getId());
			topic.setNpmScore(npmScore);
			topic.setTopic(survey.getTopic());
			topics.add(topic);
		}
		return topics;

	}

}
