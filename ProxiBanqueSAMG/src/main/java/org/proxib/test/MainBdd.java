package org.proxib.test;

import java.time.LocalDate;

import org.proxib.config.ApplicationConfig;
import org.proxib.dao.ITransactionDao;
import org.proxib.model.Adviser;
import org.proxib.model.Client;
import org.proxib.model.CurrentAccount;
import org.proxib.model.SavingAccount;
import org.proxib.model.Transaction;
import org.proxib.service.IAccountService;
import org.proxib.service.IAdviserService;
import org.proxib.service.IClientService;
import org.proxib.service.ITransactionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBdd {

	public static void main(String[] args) {
 
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

	
		IClientService clientService = context.getBean("serviceClient", IClientService.class);
		IAccountService accountService = context.getBean("serviceAccount", IAccountService.class);
		ITransactionService txnService = context.getBean("transactionService", ITransactionService.class);
		IAdviserService adviserService = context.getBean("serviceAdviser", IAdviserService.class);

		// Création de clients 
		
		Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com" );
		Client c2 = new Client("Paula", "Lis", "1 rue du paradis 75010 Paris", "paula.lis@gmail.com");
		Client c3 = new Client("bob", "marley", "10 rue des nénuphars paris", "bob@marley");
		Client c4 = new Client("bobby", "marley", "1 rue des rateaux paris", "bobby@marley");
		Client c5 = new Client("Jean", "Dujardin", "5 avenue des champs élysées 75007 Paris", "jean.dujardin@gmail.com");
		Client c6 = new Client("Alexandra", "Lamy", "86 boulevard des batignolles 75007 Paris", "a.lamy@gmail.com");
		Client c7 = new Client("Alexandre", "Le grand", "Alexandrie", "a.legrand@gmail.com");
		Client c8 = new Client("Riccu", "Ricci", "Italia", "ricuu.r@gmail.com");
		Client c9 = new Client("Harry", "Potter", "Italia", "ricuu.r@gmail.com");
		Client c10 = new Client("Riccu", "Ricci", "Italia", "ricuu.r@gmail.com");
		
				
		// Création de comptes aux clients
		CurrentAccount a1 = new CurrentAccount(1000);
		CurrentAccount a2 = new CurrentAccount(100);
		CurrentAccount a3 = new CurrentAccount(200);
		CurrentAccount a4 = new CurrentAccount(-50);
		CurrentAccount a5 = new CurrentAccount(217);
		CurrentAccount a6 = new CurrentAccount(-100);
		CurrentAccount a7 = new CurrentAccount(757);
		CurrentAccount a8 = new CurrentAccount(-2);
		
		
		
		c1.addCurrentAccountToClient(a1);
		c2.addCurrentAccountToClient(a2);
		c3.addCurrentAccountToClient(a3);
		c4.addCurrentAccountToClient(a4);
		c5.addCurrentAccountToClient(a5);
		c6.addCurrentAccountToClient(a6);
		c7.addCurrentAccountToClient(a7);
		c7.addCurrentAccountToClient(a8);
		
		SavingAccount s1 = new SavingAccount(10000);
		SavingAccount s2 = new SavingAccount(29000);
		SavingAccount s3 = new SavingAccount(117);
		SavingAccount s4 = new SavingAccount(2000);
		SavingAccount s5 = new SavingAccount(1111);
		
		
		c1.addSavingAccountToClient(s1);
		c2.addSavingAccountToClient(s2);
		c5.addSavingAccountToClient(s3);
		c7.addSavingAccountToClient(s4);
		c4.addSavingAccountToClient(s5);
		
				
		// Création de conseillers
				
		Adviser ad1 = new Adviser("Bernard", "Lermite");
		Adviser ad2 = new Adviser("Roger", "Laffite");
		Adviser ad3 = new Adviser("Mathieu", "Martin");
		Adviser ad4 = new Adviser("Jonas", "Rottin");
		
		ad1.addClientToAdviser(c1);
				
				
		// Création de transations  

				
				

		
		// Persistences des clients et tout le reste
		
		try {
			clientService.persist(c2);
			clientService.persist(c1);
			
			
			adviserService.persist(ad1);
			adviserService.persist(ad2);


			
		} catch (Exception e) {
//			e.printStackTrace();
		}
//		Transaction txn = new Transaction(LocalDate.now());
//		System.out.println("**********************************************" +LocalDate.now() + "*********************************");

		}



	}


