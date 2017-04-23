package org.proxib.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.proxib.dao.IAccountDao;
import org.proxib.dao.IClientDao;
import org.proxib.dao.ITransactionDao;
import org.proxib.model.Account;
import org.proxib.model.Client;
import org.proxib.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("serviceAccount")
public class ServiceAccount implements IAccountService {

	@Autowired
	private IAccountDao accountDao;

	@Autowired
	private IClientDao clientDao;

	@Autowired
	private ITransactionDao transactionDao;
	
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
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		
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
				
				Transaction transaction =new Transaction();
				transaction.setDate(date);
				transaction.setAccountToWithdrawId(accountToWithdraw.getId());
				transaction.setAccountToCreditId(accountToCredit.getId());
				transaction.setAmount(sum);
				transactionDao.persist(transaction);
				
				return "Virement effectué";
			} catch (Exception e) {
				System.out.println("Exception dans virement dans serviceAccount");
				e.printStackTrace();
				return "probleme Exception dans virement dans serviceAccount";
			}
			
		}
	}

	@Override
	public List<Client> doAudit(double overdraft) {
		
		List<Client> clientsOverdraft = new ArrayList<>();
		try {
			List<Client> clients = clientDao.findAll();
			for (Client client : clients) {
				if (client.getCurrentAccount() != null) {
					if (client.getCurrentAccount().getBalance() <= overdraft) {
						clientsOverdraft.add(client);
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("Exception dans doAudit de ServiceAccount");
			e.printStackTrace();
		}
		
		
		
		return clientsOverdraft;
	}

}
