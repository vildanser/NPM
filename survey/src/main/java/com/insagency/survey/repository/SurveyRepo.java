package com.insagency.survey.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.insagency.survey.entity.Survey;

@Repository
public interface SurveyRepo extends JpaRepository<Survey, Long>{

	@Query("SELECT F " + "FROM Survey F where topic=?1")
	List<Survey> findSurveyByTopic(String topic);
	
	
}
