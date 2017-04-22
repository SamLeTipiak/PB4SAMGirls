package org.proxib.test;

import org.proxib.config.ApplicationConfig;
import org.proxib.model.Client;
import org.proxib.model.CurrentAccount;
import org.proxib.model.SavingAccount;
import org.proxib.service.IAccountService;
import org.proxib.service.IClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

	public static void main(String[] args) {
 
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);


		// IClientService serviceClient = context.getBean("serviceClient",
		// IClientService.class);
		// IAccountService serviceAccount = context.getBean("serviceAccount",
		// ServiceAccount.class);
		// try {

		// Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001
		// Paris", "paul.leroy@gmail.com" );
		// Client c2 = new Client("Paula", "Lis", "18 rue des oliviers 75001
		// Paris", "paula.lis@gmail.com");
		// List<Client> clients = new ArrayList<>();
		// clients.add(c1);
		// clients.add(c2);
		// serviceClient.persist(c1);
		// serviceClient.persist(c2);
		// System.out.println(clients);
		//
		// Account compte1 = new Account(541, 456.3, typeAccount.CURRENT);
		// serviceAccount.persist(compte1);

		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		IClientService clientService = context.getBean("serviceClient", IClientService.class);
		IAccountService accountService = context.getBean("serviceAccount", IAccountService.class);
		
		Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com" );
		Client c2 = new Client("Paula", "Lis", "18 rue des oliviers 75001 Paris", "paula.lis@gmail.com");
		
		CurrentAccount a1 = new CurrentAccount(1000);
		SavingAccount a2 = new SavingAccount(29000);
		CurrentAccount a3 = new CurrentAccount(-2);
		SavingAccount a4 = new SavingAccount(2000);
		
		
		
		c2.addCurrentAccountToClient(a3);
		c2.addSavingAccountToClient(a4);
//		
		c1.addCurrentAccountToClient(a1);
		c1.addSavingAccountToClient(a2);
		
		try {
			clientService.persist(c2);
			clientService.persist(c1);
			System.out.println(accountService.transfer(a4, a3, -200));
			System.out.println(accountService.doAudit(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		




	}

}
