package org.proxib.dao.impl;



import org.proxib.dao.ITransactionDao;
import org.proxib.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TransactionDaoImpl extends EntityDaoImpl<Transaction> implements ITransactionDao{

}
