package org.proxib.test;

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

	@Test
	public void addClientNotNullTest() {

		Client client1 = new Client("bob", "marley", "b@m", "paris");
		try {
			clientService.persist(client1);
			assertNotNull(clientService.findAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	
		
		;
	}

}
