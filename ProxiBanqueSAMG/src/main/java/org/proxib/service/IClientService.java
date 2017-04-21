package org.proxib.service;

import java.util.List;

import org.proxib.model.Client;

public interface IClientService {

	void persist(Client client) throws Exception;

	void merge(Client client) throws Exception;

	void remove(Long id) throws Exception;

	Client findById(Long id) throws Exception;

	List<Client> findAll() throws Exception;
	
	List<Client> findByProperty(String prop, Object val) throws Exception;
	
//	List<Client> findInRange(int firstResult, int maxResults) throws Exception;
//	
//	long count() throws Exception;
	

}
