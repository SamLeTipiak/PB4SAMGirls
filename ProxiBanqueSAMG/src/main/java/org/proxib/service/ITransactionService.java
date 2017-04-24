package org.proxib.service;

import java.util.List;


import org.proxib.model.Transaction;

/**
 * Sont déclarées dans cette interface toutes les méthodes propres à la couche
 * Service et relatives aux actions sur les transactions. Elles sont définies dans la classe
 * {@link ServiceTransaction}.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
public interface ITransactionService {

	void persist(Transaction transaction) throws Exception;
	
	void merge(Transaction transaction) throws Exception;

	void remove(Long idTransaction) throws Exception;
	
	Transaction findById(Long idTransaction) throws Exception;
	
	List<Transaction> findAll() throws Exception;
	

	
}
