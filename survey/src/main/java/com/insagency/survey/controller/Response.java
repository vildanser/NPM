package com.insagency.survey.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@lombok.Getter
@lombok.Setter
@AllArgsConstructor
public class Response {
	private String code;
	private String message;
	private List data;

	public <T> Response(String code, String message, T entity) {
		this.code = code;
		this.message = message;
		data = Arrays.asList(entity);
	}
}
