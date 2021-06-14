package com.insagency.survey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SURVEY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Survey extends BaseClass {

	private static final long serialVersionUID = 1L;

	@NotNull
    @Column(name = "topic", nullable = false)
	private String topic;
	
	@NotNull
    @Column(name = "question", nullable = false)
	private String question;
	
	@NotNull
    @Column(name = "npmscore", nullable = true)
	private Long npmscore;

}
