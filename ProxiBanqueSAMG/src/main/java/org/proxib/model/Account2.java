package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

//@Entity
//@Component
public class Account2 {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double balance;
	private double rate;
	private String typeAccount;
	
//	@ManyToOne(cascade = { CascadeType.ALL })
//	@JoinColumn(name = "client_id")
	private Client client;

	

	public Account2() {
		super();
	}

	public Account2(double balance, double rate, String typeAccount) {
		super();
		this.balance = balance;
		this.rate = rate;
		this.typeAccount = typeAccount;
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


	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte " + typeAccount +" : " + balance + " €\n";
	}

	
}