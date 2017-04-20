package org.proxib.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.proxib.config.ApplicationConfig;
import org.proxib.model.Client;
import org.proxib.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class TestDaoClient {

	@Autowired
	IClientService clientService;

	Client client1 = new Client("bob", "marley", "b@m", "paris");
	
	@Test
	public void addClientNotNullTest() {

		
		try {
			clientService.persist(client1);
			assertNotNull(clientService.findAll());
			assertEquals(1, clientService.findAll().size());
			assertEquals("bob", clientService.findAll().get(0).getFirstName());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void updateTest() {

//		Client client1 = new Client("bob", "marley", "b@m", "paris");
//		Client client1 = new Client();
		try {
			
//			clientService.persist(client1);
			client1.setFirstName("bobby");
			clientService.merge(client1);
			assertEquals("bobby", clientService.findAll().get(0).getFirstName());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
