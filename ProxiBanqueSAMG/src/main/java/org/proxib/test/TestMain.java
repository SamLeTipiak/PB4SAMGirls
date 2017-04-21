package org.proxib.test;

import org.proxib.config.ApplicationConfig;
import org.proxib.model.Account;
import org.proxib.model.Account.typeAccount;
import org.proxib.model.Client;
import org.proxib.service.IAccountService;
import org.proxib.service.IClientService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {

	public static void main(String[] args) {
 
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		
		IClientService serviceClient = context.getBean("serviceClient", IClientService.class);
		IAccountService serviceAccount = context.getBean("serviceAccount", IAccountService.class);
		try {

			Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com" );
			Client c2 = new Client("Paula", "Lis", "18 rue des oliviers 75001 Paris", "paula.lis@gmail.com");
//			List<Client> clients = new ArrayList<>();
//			clients.add(c1);
//			clients.add(c2);
//			serviceClient.persist(c1);
//			serviceClient.persist(c2);
//			System.out.println(clients);
//			
			Account compte1 = new Account(541, 456.3, typeAccount.CURRENT);
			Account compte2 = new Account(777, 0.2, typeAccount.SAVING);
			
			c1.addAccountToClient(compte1);
			c1.addAccountToClient(compte2);
			
//			
//			serviceAccount.persist(compte1);
			

			serviceClient.persist(c1);
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		



	}

}
