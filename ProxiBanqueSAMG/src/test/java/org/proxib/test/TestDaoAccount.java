package org.proxib.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxib.config.ApplicationConfig;
import org.proxib.dao.IAccountDao;
import org.proxib.dao.impl.AccountDaoImpl;
import org.proxib.model.Account;
import org.proxib.model.Account.typeAccount;
import org.proxib.service.IAccountService;
import org.proxib.service.ServiceAccount;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ApplicationConfig.class})
public class TestDaoAccount {

//	@Autowired
//	private IAccountService accountService;
	
	IAccountService accountService = new ServiceAccount();
	IAccountDao accountDao = new AccountDaoImpl();
	
	
	@Test
	public void testAddAccount() {
		System.out.println("entrée dans le test addAccount");
		Account account1 = new Account(2000, 0.5, typeAccount.CURRENT);
		List<Account> listAccounts = new ArrayList<>();
		try {
			accountDao.persist(account1);
			System.out.println("persistance okay");
			listAccounts =  accountDao.findAll();
			System.out.println("list okay");
		} catch (Exception e) {
			System.out.println("Pb. dans le test");
			e.printStackTrace();
		}
		
		assertEquals(1, listAccounts.size());
		
	}
	
//	@Test
//	public void testServiceAddAccount() {
//		System.out.println("entrée dans le test addAccount");
//		Account account1 = new Account(2000, 0.5, typeAccount.CURRENT);
//		List<Account> listAccounts = new ArrayList<>();
//		try {
//			accountService.persist(account1);
//			listAccounts =  accountService.findAll();
//		} catch (Exception e) {
//			System.out.println("Pb. dans le test");
//			e.printStackTrace();
//		}
//		
//		assertEquals(1, listAccounts.size());
//		
//	}


}
