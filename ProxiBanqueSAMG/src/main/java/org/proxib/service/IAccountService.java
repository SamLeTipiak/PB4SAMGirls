package org.proxib.service;

import java.util.List;

import org.proxib.model.Account;
import org.proxib.model.Client;

public interface IAccountService {

	public void persist(Account account) throws Exception;
	
	public void merge(Account account) throws Exception;

	public void remove(Long idAccount) throws Exception;
	
	public Account findById(Long idAccount) throws Exception;
	
	public List<Account> findAll() throws Exception;
	
	public String transfer(Account accountToWithdraw, Account accountToCredit, double sum);
	
	public List<Client> doAudit(double overdraft);
	
//	List<Account> findByProperty(String prop, Object val) throws Exception;
//	
//	List<Account> findInRange(int firstResult, int maxResults) throws Exception;
//	
//	long count() throws Exception;
	
	
}
