package org.proxib.service;

import java.util.List;

import org.proxib.model.Account;

public interface IAccount {

	void persist(Account account) throws Exception;
	
	void merge(Account account) throws Exception;

	void remove(Long idAccount) throws Exception;
	
	Account findById(Long idAccount) throws Exception;
	
	List<Account> findAll() throws Exception;
	
//	List<Account> findByProperty(String prop, Object val) throws Exception;
//	
//	List<Account> findInRange(int firstResult, int maxResults) throws Exception;
//	
//	long count() throws Exception;
	
	
}
