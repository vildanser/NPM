package com.insagency.survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "ANSWER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Answer extends BaseClass {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "surveyid", nullable = false)
	private Long surveyid;

	@NotNull
	@Column(name = "answer", nullable = false)
	private String answer;

	@NotNull
	@Column(name = "score", nullable = false)
	private Long score;

	

}
