package org.proxib.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
//@Component
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTransaction;
//	private Account accountToWithdraw;
//	private Account accountToCredit;
	private LocalDate date;
	private double amount;

	public Transaction() {
		super();
	}
	

	public Transaction(LocalDate date) {
		super();
		this.date = date;
	}


//	public Transaction(Account accountToWithdraw, Account accountToCredit, LocalDate date, double amount) {
//		super();
//		this.accountToWithdraw = accountToWithdraw;
//		this.accountToCredit = accountToCredit;
//		this.date = date;
//		this.amount = amount;
//	}

//	public Account getAccountToWithdraw() {
//		return accountToWithdraw;
//	}
//
//	public void setAccountToWithdraw(Account accountToWithdraw) {
//		this.accountToWithdraw = accountToWithdraw;
//	}
//
//	public Account getAccountToCredit() {
//		return accountToCredit;
//	}
//
//	public void setAccountToCredit(Account accountToCredit) {
//		this.accountToCredit = accountToCredit;
//	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Transaction [date=" + date + "]";
	}

}
