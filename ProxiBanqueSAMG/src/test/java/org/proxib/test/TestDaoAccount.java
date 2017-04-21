package org.proxib.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxib.config.ApplicationConfig;
import org.proxib.model.Account;
import org.proxib.model.Account.typeAccount;
import org.proxib.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class TestDaoAccount {

	// @Autowired
	// private IAccountService accountService;

	// IAccountService accountService = new ServiceAccount();
	// IAccountDao accountDao = new AccountDaoImpl();

	@Autowired
	IAccountService accountService;

	Account account1 = null;
	Account account2 = null;

	@Before
	public void createDB() {
		account1 = new Account(2000, 0.5, typeAccount.CURRENT);
		account2 = new Account(2000, 0.5, typeAccount.CURRENT);
		try {
			accountService.persist(account1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	// public void testAddAccount() {
	//
	//
	// System.out.println("entrée dans le test addAccount");
	//
	//// List<Account> listAccounts = new ArrayList<>();
	// try {
	// Account account1 = new Account(2000, 0.5, typeAccount.CURRENT);
	// accountDao.persist(account1);
	// System.out.println("persistance okay");
	// //listAccounts = accountDao.findAll();
	// //System.out.println("list okay");
	//// assertEquals(1, accountDao.findAll().size());
	// assertEquals(typeAccount.CURRENT,
	// accountDao.findAll().get(0).getTypeAccount());
	// } catch (Exception e) {
	// System.out.println("Pb. dans le test");
	// e.printStackTrace();
	// }
	//
	//// assertEquals(1, listAccounts.size());
	//
	//
	// }

	@Test
	public void testServiceAddAccount() {
		try {
			int sizeBefore = accountService.findAll().size();
			accountService.persist(account2);
			assertEquals(sizeBefore + 1, accountService.findAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testServiceReadAccount() {
		try {
			assertEquals(typeAccount.CURRENT,
					accountService.findAll().get(accountService.findAll().size() - 1).getTypeAccount());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testServiceUpdateAccount(){
		
		account1.setBalance(300);
		try {
			accountService.merge(account1);
			assertEquals(300, accountService.findById(account1.getId()).getBalance(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testServiceDeleteAccount() {
		try {
			int sizeBefore = accountService.findAll().size();
			accountService.remove(accountService.findAll().get(accountService.findAll().size() - 1).getId());
			assertEquals(sizeBefore - 1, accountService.findAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@After
	public void deleteDB() {
		try {
			accountService.remove(accountService.findAll().get(accountService.findAll().size()-1).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
