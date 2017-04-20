package org.proxib.dao.impl;

import org.proxib.dao.IAccountDao;
import org.proxib.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AccountDaoImpl extends EntityDaoImpl<Account> implements IAccountDao {

	
}
