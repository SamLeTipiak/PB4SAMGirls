package org.proxib.config;

import java.time.LocalDate;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.proxib.model.Account;
import org.proxib.model.Transaction;
import org.proxib.service.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectConfig {
	
	@Autowired
	ITransactionService transactionService;

	Logger LOGGER = LoggerFactory.getLogger(AspectConfig.class);
	
	@Pointcut("execution(* org.proxib.service.IAccountService.transfer(..)) ")
	public void transactions() {
		
	}
	
	@AfterReturning("transactions()")
	public void logTransaction() {
		System.out.println("*****************************dans aspect************************");
		Transaction transaction = new Transaction(LocalDate.now());
		try {
			transactionService.persist(transaction);
			System.out.println("**************************persit**********************");
			LOGGER.info("Virement effectuéééééé");
		} catch (Exception e) {
			System.out.println("*******************Exception****************");
			e.printStackTrace();
		}
	}
	
	
//	public String transfer(Account accountToWithdraw, Account accountToCredit, double sum) {
//		
//		Transaction transaction = new Transaction(accountToWithdraw, accountToCredit, LocalDate.now(), sum);
//		try {
//			transactionService.persist(transaction);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
//		return null;
//		
//	}
	
}
