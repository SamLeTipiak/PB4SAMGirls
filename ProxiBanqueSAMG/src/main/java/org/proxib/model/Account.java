package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * <b>Account représente les comptes bancaires ouverts chez ProxiBanque.</b>
 * <p>
 * Chaque compte est caractérisé par les informations suivantes :
 * <ul>
 * <li>id : un identifiant généré automatiquement au niveau de la base de
 * données</li>
 * <li>balance : le solde du compte</li>
 * <li>rate : la rémunération du compte</li>
 * </ul>
 * </p>
 * <p>
 * Chaque compte est aussi associé à un client.
 * </p>
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	protected double balance;
	protected double rate;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	private Client client;

	
	// Constructeurs

	public Account(double balance, double rate) {
		super();
		this.balance = balance;
		this.rate = rate;
	}

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public Account() {
		super();
	}

	// Getters Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance += balance;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// No modif allowed
	@Override
	public String toString() {
		return " " + balance;
	}

}
