package org.proxib.dao.impl;

import org.proxib.dao.IAccountDao;
import org.proxib.dao.IClientDao;
import org.proxib.model.Account;
import org.proxib.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * AccountDaoImpl étend {@link EntityDaoImpl}, implémente {@link IAccountDao} et s'applique donc
 * au type {@link Account}.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Repository
@Transactional
public class AccountDaoImpl extends EntityDaoImpl<Account> implements IAccountDao {

	
}
