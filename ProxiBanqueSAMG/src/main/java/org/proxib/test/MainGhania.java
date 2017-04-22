package org.proxib.test;

import org.proxib.config.ApplicationConfig;
import org.proxib.model.Client;
import org.proxib.model.CurrentAccount;
import org.proxib.model.SavingAccount;
import org.proxib.service.IAccountService;
import org.proxib.service.IClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainGhania {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com" );
		IClientService clientService = context.getBean("serviceClient", IClientService.class);
		IAccountService as = context.getBean("serviceAccount", IAccountService.class);
		Client c2 = new Client("Paula", "Lis", "18 rue des oliviers 75001 Paris", "paula.lis@gmail.com");
		CurrentAccount a1 = new CurrentAccount(1232, 0.3);
		SavingAccount a2 = new SavingAccount(29000, 1.2);
		CurrentAccount a3 = new CurrentAccount(2, 0.2);
		SavingAccount a4 = new SavingAccount(2000, 0.2);
		c2.addCurrentAccountToClient(a3);
//		a3.addClientToCurrentAccount(c2);
		c2.addSavingAccountToClient(a4);
		
		c1.addCurrentAccountToClient(a1);
		c1.addSavingAccountToClient(a2);
		
		try {
			clientService.persist(c2);
//			as.persist(a3);
			clientService.persist(c1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
