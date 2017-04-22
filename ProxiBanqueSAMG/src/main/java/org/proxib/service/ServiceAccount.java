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

	@Override
	public String transfer(Account accountToWithdraw, Account accountToCredit, double sum) {
		if (sum <= 0.0) {
			return "La somme est inférieure ou égale à 0";
		}
		else if (accountToWithdraw == accountToCredit) {
			return "Memes comptes ! ";
		}
		else if (sum >= accountToWithdraw.getBalance()) {
			return "Somme supérieure au montant de votre compte en banque !";
		}
		else {
			accountToWithdraw.setBalance(-sum);
			accountToCredit.setBalance(sum);
			try {
				accountDao.merge(accountToWithdraw);
				accountDao.merge(accountToCredit);
				return "Virement effectué";
			} catch (Exception e) {
				System.out.println("Exception dans virement dans serviceAccount");
				e.printStackTrace();
				return "probleme Exception dans virement dans serviceAccount";
			}
			
		}
	}

}
