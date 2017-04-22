package org.proxib.service;

import java.util.List;


import org.proxib.model.Transaction;

public interface ITransactionService {

	void persist(Transaction transaction) throws Exception;
	
	void merge(Transaction transaction) throws Exception;

	void remove(Long idTransaction) throws Exception;
	
	Transaction findById(Long idTransaction) throws Exception;
	
	List<Transaction> findAll() throws Exception;
	
//	List<Account> findByProperty(String prop, Object val) throws Exception;
//	
//	List<Account> findInRange(int firstResult, int maxResults) throws Exception;
//	
//	long count() throws Exception;
	
}
