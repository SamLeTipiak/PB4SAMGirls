package org.proxib.test;

import java.util.ArrayList;
import java.util.List;

import org.proxib.config.ApplicationConfig;
import org.proxib.model.Account;
import org.proxib.model.Account.typeAccount;
import org.proxib.model.Adviser;
import org.proxib.model.Client;
import org.proxib.service.IAccountService;
import org.proxib.service.IAdviserService;
import org.proxib.service.IClientService;
import org.proxib.service.ServiceAdviser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMainA {

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

		Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com" );
		IClientService clientService = context.getBean("serviceClient", IClientService.class);
		Client c2 = new Client("Paula", "Lis", "18 rue des oliviers 75001 Paris", "paula.lis@gmail.com");
		Account a3 = new Account(2, 0.2, typeAccount.CURRENT);
		Account a4 = new Account(2000, 0.2, typeAccount.SAVING);
		c2.addAccountToClient(a3);
		c2.addAccountToClient(a4);

		List<Client> clients= new ArrayList<>();
		clients.add(c1);
		clients.add(c2);
		Adviser ad1 = new Adviser("El", "Castador");
		Adviser ad2 = new Adviser("m", "C");
		Adviser ad3 = new Adviser("ma", "Co");
		List<Adviser> advisers = new ArrayList<>();
		
		
		IAdviserService adviserService = context.getBean("serviceAdviser", IAdviserService.class);
		
		try {
			adviserService.persist(ad1);
			adviserService.persist(ad2);
			adviserService.persist(ad3);
			
			advisers = adviserService.findAll();
			System.out.println(advisers);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		



	}

}