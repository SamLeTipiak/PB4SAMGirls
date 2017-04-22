package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
//@Component
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	protected double balance;
	protected double rate;

	
	@ManyToOne( cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
//	@JoinColumn(name="client_id")
	private Client client;


	public Account() {
		super();
	}

	public Account(double balance, double rate) {
		super();
		this.balance = balance;
		this.rate = rate;
	}
	
	public Account(double balance) {
		super();
		this.balance = balance;
	}
	
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
		this.balance = balance;
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

	@Override
	public String toString() {
		return "Compte  : " + balance + " €\n";
	}

	
}
