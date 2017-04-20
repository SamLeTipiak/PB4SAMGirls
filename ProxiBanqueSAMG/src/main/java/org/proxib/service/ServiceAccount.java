package org.proxib.service;

import java.util.List;

import org.proxib.dao.IAccountDao;
import org.proxib.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("serviceAccount")
public class ServiceAccount implements IAccountService {

	@Autowired
	private IAccountDao accountDao;


	
	@Override
	public void persist(Account account) throws Exception {
		accountDao.persist(account);
	}

	@Override
	public void merge(Account account) throws Exception {
		accountDao.merge(account);
	}

	@Override
	public void remove(Long idAccount) throws Exception {
		accountDao.remove(idAccount);

	}

	@Override
	public Account findById(Long idAccount) throws Exception {
		return accountDao.findById(idAccount);
	}

	@Override
	public List<Account> findAll() throws Exception {
		return accountDao.findAll();
	}

}
