package org.proxib.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxib.config.ApplicationConfig;
import org.proxib.model.Account;
import org.proxib.model.CurrentAccount;
import org.proxib.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class TestDaoAccount {

	@Autowired
	IAccountService accountService;

	Account account1 = new CurrentAccount(2000, 0.5);

	@Test
	public void testServiceAddAccount() {
		try {
			int sizeBefore = accountService.findAll().size();
			accountService.persist(account1);
			assertEquals(sizeBefore + 1, accountService.findAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testServiceReadAccount() {
		try {
			assertEquals(2000,
					accountService.findAll().get(accountService.findAll().size() - 1).getBalance(),0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testServiceUpdateAccount(){
		
		try {
			account1=accountService.findAll().get(accountService.findAll().size()-1);
			account1.setBalance(300);
			accountService.merge(account1);
			assertEquals(300, accountService.findById(account1.getId()).getBalance(), 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testServiceDeleteAccount() {
		try {
			int sizeBefore = accountService.findAll().size();
			accountService.remove(accountService.findAll().get(accountService.findAll().size() - 1).getId());
			assertEquals(sizeBefore-1, accountService.findAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
