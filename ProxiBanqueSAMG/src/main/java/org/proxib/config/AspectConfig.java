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

		try {
			LOGGER.warn("Nature de la transaction : Virement compte à compte");
			LOGGER.warn(
					"Date : " + transactionService.findAll().get(transactionService.findAll().size() - 1).getDate());
			LOGGER.warn("Montant : "
					+ transactionService.findAll().get(transactionService.findAll().size() - 1).getAmount() + "€");
			LOGGER.warn("Compte débité n° : " + transactionService.findAll().get(transactionService.findAll().size() - 1).getAccountToWithdrawId());
			LOGGER.warn("Compte crédité n° : " + transactionService.findAll().get(transactionService.findAll().size() - 1).getAccountToCreditId() +"\n\n");
		} catch (Throwable e) {
			LOGGER.info("Exception");
			e.printStackTrace();
		}

	}

}
