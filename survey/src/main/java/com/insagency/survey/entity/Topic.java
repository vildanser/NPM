package com.insagency.survey.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@lombok.Getter
@lombok.Setter
public class Topic extends BaseClass {

	private static final long serialVersionUID = 1L;
	private String topic;
	private int npmScore;
}
