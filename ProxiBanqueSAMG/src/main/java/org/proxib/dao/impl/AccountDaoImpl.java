package org.proxib.dao.impl;

import org.proxib.dao.AccountDao;
import org.proxib.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AccountDaoImpl extends EntityDaoImpl<Account> implements AccountDao {

	
}
