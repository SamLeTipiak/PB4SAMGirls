package org.proxib.dao.impl;



import org.proxib.dao.IClientDao;
import org.proxib.dao.ITransactionDao;
import org.proxib.model.Client;
import org.proxib.model.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * TransactionDaoImpl étend {@link EntityDaoImpl}, implémente {@link ITransactionDao} et s'applique donc
 * au type {@link Transaction}.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Repository
@Transactional
public class TransactionDaoImpl extends EntityDaoImpl<Transaction> implements ITransactionDao{

}
