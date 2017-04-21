package org.proxib.service;

import java.util.List;

import org.proxib.model.Adviser;

public interface IAdviserService {

	void persist(Adviser adviser) throws Exception;

	void merge(Adviser adviser) throws Exception;

	void remove(Long id) throws Exception;

	Adviser findById(Long id) throws Exception;

	List<Adviser> findAll() throws Exception;
	
//	List<Adviser> findByProperty(String prop, Object val) throws Exception;
	
//	List<Adviser> findInRange(int firstResult, int maxResults) throws Exception;
//	
//	long count() throws Exception;
	

}
