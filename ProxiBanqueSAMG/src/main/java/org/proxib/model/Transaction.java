package org.proxib.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <b>Director représente le directeur d'agence.</b>
 * <p>Il est caractérisé par :</p>
 * <ul>
 * <li>id : un identifiant généré automatiquement (par incrémentation) au niveau de la base de données.</li>
 * <li>firstName : son prénom</li>
 * <li>lastName : son nom de famille</li>
 * </ul>
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania Bouzemame
 * @version 1.0
 *
 */
@Entity
//@Component
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTransaction;
	private Long accountToWithdrawId;
	private Long accountToCreditId;
	private Date date;
	private double amount;

	public Transaction() {
		super();
	}
	

	public Transaction(Date date) {
		super();
		this.date = date;
	}


	public Transaction(Long accountToWithdrawId, Long accountToCreditId, Date date, double amount) {
		super();
		this.accountToWithdrawId = accountToWithdrawId;
		this.accountToCreditId = accountToCreditId;
		this.date = date;
		this.amount = amount;
	}



	public Long getAccountToWithdrawId() {
		return accountToWithdrawId;
	}


	public void setAccountToWithdrawId(Long accountToWithdrawId) {
		this.accountToWithdrawId = accountToWithdrawId;
	}


	public Long getAccountToCreditId() {
		return accountToCreditId;
	}


	public void setAccountToCreditId(Long accountToCreditId) {
		this.accountToCreditId = accountToCreditId;
	}


	public Transaction(Date date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double sum) {
		this.amount = sum;
	}


	@Override
	public String toString() {
		return "Transaction [date=" + date + "]";
	}

}
