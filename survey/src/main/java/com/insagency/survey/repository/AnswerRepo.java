package com.insagency.survey.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.insagency.survey.entity.Answer;
import com.insagency.survey.entity.AnswerOutput;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {

	@Query("SELECT new com.insagency.survey.entity.AnswerOutput(F.id, F.answer, F.score )" + " FROM Answer F, Survey S "
			+ "WHERE  S.topic=?1 AND F.surveyid=S.id")
	List<AnswerOutput> findAnswerTopic(String topic);

	List<Answer> findAllBySurveyid(Long surveyid);
}
