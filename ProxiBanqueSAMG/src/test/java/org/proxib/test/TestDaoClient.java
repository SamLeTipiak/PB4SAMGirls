package org.proxib.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxib.config.ApplicationConfig;
import org.proxib.model.Account;
import org.proxib.model.Client;
import org.proxib.model.Account.typeAccount;
import org.proxib.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class TestDaoClient {

	@Autowired
	IClientService clientService;

	
	Account account1 = new Account(2000, 0.5, typeAccount.CURRENT);
	Client client1 = new Client("Bob", "Le Bricoleur", "rue des btp", "bob@trav.aux");




	@Test
	public void testServiceAddClient() {
		try {
			int sizeBefore = clientService.findAll().size();
			client1.addAccountToClient(account1);
			
			clientService.persist(client1);
			assertEquals(sizeBefore + 1, clientService.findAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testServiceReadClient() {
		try {
			assertEquals("bob@trav.aux",
					clientService.findAll().get(clientService.findAll().size() - 1).getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testServiceUpdateClient(){
		
	
		try {
			client1=clientService.findAll().get(clientService.findAll().size()-1);
			client1.setaddress("Avenue des Travaux");
			clientService.merge(client1);
			assertEquals("Avenue des Travaux", clientService.findById(client1.getId()).getaddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testServiceDeleteClient() {
		try {
			int sizeBefore = clientService.findAll().size();
			clientService.remove(clientService.findAll().get(clientService.findAll().size() - 1).getId());
			assertEquals(sizeBefore - 1, clientService.findAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
