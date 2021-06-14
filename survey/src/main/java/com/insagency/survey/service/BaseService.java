package com.insagency.survey.service;


import java.util.Optional;


public interface BaseService<T> {
	public T save(T entity);
	public Optional<T> getById(Long id);
	
}
