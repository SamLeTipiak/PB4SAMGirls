package org.proxib.dao.impl;

import org.proxib.dao.IAccountDao;
import org.proxib.model.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AccountDaoImpl extends EntityDaoImpl<Account> implements IAccountDao {

	
}
