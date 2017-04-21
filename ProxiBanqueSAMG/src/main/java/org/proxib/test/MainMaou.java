package org.proxib.test;

import org.proxib.config.ApplicationConfig;
import org.proxib.model.Account;
import org.proxib.model.Client;
import org.proxib.service.IClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class MainMaou {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		IClientService clientService = context.getBean("serviceClient", IClientService.class);
		Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com" );
		Client c2 = new Client("Marron", "Is", "18 rue des oliviers 75001 Paris", "paula.lis@gmail.com");
		Account a3 = new Account(2, 0.2);
		Account a4 = new Account(2000, 0.2);
		c1.addCurrentAccountToClient(a3);
		c2.addSavingAccountToClient(a4);
		
		try {
			clientService.persist(c2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
