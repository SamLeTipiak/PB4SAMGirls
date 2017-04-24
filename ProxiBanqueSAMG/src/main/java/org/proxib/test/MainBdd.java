package org.proxib.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.proxib.config.ApplicationConfig;
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
		Client c5 = new Client("Jean", "Dujardin", "5 avenue des champs Elysées 75007 Paris", "jean.dujardin@gmail.com");
		Client c6 = new Client("Alexandra", "Lamy", "86 boulevard des batignolles 75007 Paris", "a.lamy@gmail.com");
		Client c7 = new Client("Alexandre", "Le grand", "Alexandrie", "a.legrand@gmail.com");
		Client c8 = new Client("Riccu", "Ricci", "Italia", "ricuu.r@gmail.com");
		Client c9 = new Client("Harry", "Potter", "Grande Bretagne", "harry.potter@gmail.com");
		Client c10 = new Client("Richard", "Coeur de Lion", "Gaulle", "r.lion.r@gmail.com");
		
				
		// Création de comptes 
		CurrentAccount a1 = new CurrentAccount(1000);
		CurrentAccount a2 = new CurrentAccount(51000);
		CurrentAccount a3 = new CurrentAccount(200);
		CurrentAccount a4 = new CurrentAccount(-50);
		CurrentAccount a5 = new CurrentAccount(217);
		CurrentAccount a6 = new CurrentAccount(-100);
		CurrentAccount a7 = new CurrentAccount(757);
		CurrentAccount a8 = new CurrentAccount(-2);
		CurrentAccount a9 = new CurrentAccount(77007);
		CurrentAccount a10 = new CurrentAccount(562);
		
		
		
		c1.addCurrentAccountToClient(a1);
		c2.addCurrentAccountToClient(a2);
		c3.addCurrentAccountToClient(a3);
		c4.addCurrentAccountToClient(a4);
		c5.addCurrentAccountToClient(a5);
		c6.addCurrentAccountToClient(a6);
		c7.addCurrentAccountToClient(a7);
		c8.addCurrentAccountToClient(a8);
		c9.addCurrentAccountToClient(a9);
		c10.addCurrentAccountToClient(a10);
		
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
		ad1.addClientToAdviser(c4);
		
		ad2.addClientToAdviser(c2);
		ad2.addClientToAdviser(c3);
		ad2.addClientToAdviser(c9);
		
		
		ad3.addClientToAdviser(c5);
		ad3.addClientToAdviser(c7);
		ad3.addClientToAdviser(c10);
		
		ad4.addClientToAdviser(c6);
		ad4.addClientToAdviser(c8);

				
		// Création de transations  

		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Transaction trans1=null,trans2=null,trans3=null,trans4=null,trans5=null,trans6=null,trans7=null,trans8=null,trans9=null,trans10=null,trans11=null,trans12=null,trans13=null;
		
		try {
			trans1=new Transaction(1L,2L,dateFormat.parse("2017/04/14"),150);
			trans2=new Transaction(1L,3L,dateFormat.parse("2017/04/29"),1150);
			trans3=new Transaction(1L,4L,dateFormat.parse("2017/04/10"),15);
			trans4=new Transaction(2L,3L,dateFormat.parse("2017/03/20"),1510);
			trans5=new Transaction(2L,4L,dateFormat.parse("2017/03/27"),50);
			trans6=new Transaction(2L,1L,dateFormat.parse("2017/04/03"),1580);
			trans7=new Transaction(3L,2L,dateFormat.parse("2017/04/15"),850);
			trans8=new Transaction(3L,1L,dateFormat.parse("2017/04/23"),4150);
			trans9=new Transaction(3L,4L,dateFormat.parse("2017/04/29"),40);
			trans10=new Transaction(4L,2L,dateFormat.parse("2017/04/01"),6150);
			trans11=new Transaction(4L,2L,dateFormat.parse("2017/04/12"),60);
			trans12=new Transaction(4L,1L,dateFormat.parse("2017/04/16"),750);
			trans13=new Transaction(4L,3L,dateFormat.parse("2017/04/26"),1530);
			
			
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
				

		
		// Persistences des clients et tout le reste
		
		try {
			
			adviserService.persist(ad1);
			adviserService.persist(ad2);
			adviserService.persist(ad3);
			adviserService.persist(ad4);


			txnService.persist(trans1);
			txnService.persist(trans2);
			txnService.persist(trans3);
			txnService.persist(trans4);
			txnService.persist(trans5);
			txnService.persist(trans6);
			txnService.persist(trans7);
			txnService.persist(trans8);
			txnService.persist(trans9);
			txnService.persist(trans10);
			txnService.persist(trans11);
			txnService.persist(trans12);
			txnService.persist(trans13);
			
			
			// faire des transferts a la date d'aujourd'hui
			accountService.transfer(a2, a3, 200);
			
			
		} catch (Exception e) {
			//TODO : Logger
			e.printStackTrace();
		
		}



	}
}

