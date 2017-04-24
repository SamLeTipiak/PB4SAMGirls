package org.proxib.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * <b>Transaction représente les transactions financières de la banque.</b>
 * <p>
 * Il est caractérisé par :
 * </p>
 * <ul>
 * <li>idTransaction : un identifiant généré automatiquement (par
 * incrémentation) au niveau de la base de données.</li>
 * <li>accountToWithdrawId : l'id du compte qui est débité</li>
 * <li>accountToCreditId : l'id du compte qui est crédité</li>
 * <li>date : la date de la transaction</li>
 * <li>amount : le montant de la transaction
 * </ul>
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTransaction;
	private Long accountToWithdrawId;
	private Long accountToCreditId;
	private Date date;
	private double amount;

	// Constructeurs

	public Transaction(Long accountToWithdrawId, Long accountToCreditId, Date date, double amount) {
		super();
		this.accountToWithdrawId = accountToWithdrawId;
		this.accountToCreditId = accountToCreditId;
		this.date = date;
		this.amount = amount;
	}

	public Transaction(Date date) {
		super();
		this.date = date;
	}

	public Transaction() {
		super();
	}

	// Getters Setters

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
