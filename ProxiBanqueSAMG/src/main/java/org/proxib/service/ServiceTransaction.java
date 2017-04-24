package org.proxib.service;

import java.util.List;

import org.proxib.dao.ITransactionDao;
import org.proxib.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>ServiceTraansaction implémente l'interface {@link ITransactionService} et
 * définit les méthodes qui vont permettre d'appeler celles de la couche de
 * persistence s'appliquant aux transactions au sein de la banque.</b>
 * <p>
 * Ici sont donc définies les méthodes propres à la couche Service et relatives
 * aux actions sur les transactions.
 * </p>
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 */
@Service("transactionService")
public class ServiceTransaction implements ITransactionService {

	@Autowired
	ITransactionDao transactionDao;

	@Override
	public void persist(Transaction transaction) throws Exception {
		transactionDao.persist(transaction);

	}

	@Override
	public void merge(Transaction transaction) throws Exception {
		transactionDao.merge(transaction);

	}

	@Override
	public void remove(Long idTransaction) throws Exception {
		transactionDao.remove(idTransaction);

	}

	@Override
	public Transaction findById(Long idTransaction) throws Exception {

		return transactionDao.findById(idTransaction);
	}

	@Override
	public List<Transaction> findAll() throws Exception {
		return transactionDao.findAll();
	}

}
