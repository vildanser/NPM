package com.insagency.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerOutput {

	private Long submitid;
	private String answer;
	private Long score;
	
}

