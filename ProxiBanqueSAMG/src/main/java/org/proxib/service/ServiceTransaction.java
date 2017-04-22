package org.proxib.service;

import java.util.List;

import org.proxib.dao.ITransactionDao;
import org.proxib.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
