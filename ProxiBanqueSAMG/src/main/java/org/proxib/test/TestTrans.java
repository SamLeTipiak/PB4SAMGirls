package org.proxib.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.proxib.config.ApplicationConfig;
import org.proxib.dao.ITransactionDao;
import org.proxib.model.Client;
import org.proxib.model.CurrentAccount;
import org.proxib.model.SavingAccount;
import org.proxib.model.Transaction;
import org.proxib.service.IAccountService;
import org.proxib.service.IClientService;
import org.proxib.service.ITransactionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mysql.fabric.xmlrpc.base.Data;

public class TestTrans {

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
		ITransactionService txnService = context.getBean("transactionService", ITransactionService.class);
		
		Client c1 = new Client("Paul", "Leroy", "17 rue des oliviers 75001 Paris", "paul.leroy@gmail.com" );
		Client c2 = new Client("Paula", "Lis", "18 rue des oliviers 75001 Paris", "paula.lis@gmail.com");
		
		CurrentAccount a1 = new CurrentAccount(1000);
		SavingAccount a2 = new SavingAccount(29000);
		CurrentAccount a3 = new CurrentAccount(-2);
		SavingAccount a4 = new SavingAccount(2000);
		
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
		
		
		c2.addCurrentAccountToClient(a3);
		c2.addSavingAccountToClient(a4);
//		
		c1.addCurrentAccountToClient(a1);
		c1.addSavingAccountToClient(a2);
		
		try {
			
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
			
			clientService.persist(c2);
			clientService.persist(c1);

			System.out.println(accountService.transfer(a4, a3, 200));

			System.out.println(accountService.transfer(a4, a3, -200));
			System.out.println(accountService.doAudit(0));

			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Transaction txn = new Transaction(LocalDate.now());
//		System.out.println("**********************************************" +LocalDate.now() + "*********************************");
//		try {
//			txnService.persist(txn);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			System.out.println(txnService.findById(1l));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
