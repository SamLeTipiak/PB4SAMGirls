package org.proxib.service;

import java.util.List;

import org.proxib.model.Account;
import org.proxib.model.Client;

/**
 * Sont déclarées dans cette interface toutes les méthodes propres à la couche
 * Service et relatives aux actions sur les comptes. Elles sont définies dans la
 * classe {@link ServiceAccount}.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
public interface IAccountService {

	public void persist(Account account) throws Exception;

	public void merge(Account account) throws Exception;

	public void remove(Long idAccount) throws Exception;

	public Account findById(Long idAccount) throws Exception;

	public List<Account> findAll() throws Exception;

	public String transfer(Account accountToWithdraw, Account accountToCredit, double sum);

	public List<Client> doAudit(double overdraft);

	// List<Account> findByProperty(String prop, Object val) throws Exception;
	//
	// List<Account> findInRange(int firstResult, int maxResults) throws
	// Exception;
	//
	// long count() throws Exception;

}
