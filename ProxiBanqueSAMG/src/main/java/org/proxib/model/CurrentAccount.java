package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CurrentAccount {
	
	private static float CURRENTRATE=0.00f;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	protected double balance;
	protected double rate;
	
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

	public static float getCURRENTRATE() {
		return CURRENTRATE;
	}

	@OneToOne(mappedBy="currentAccount", cascade = CascadeType.ALL)
	private Client client;
	
	


	public CurrentAccount() {
		super();
	}

	public CurrentAccount(Long id, double balance, double rate, Client client) {
		super();
		this.id = id;
		this.balance = balance;
		this.rate = rate;
		this.client = client;
	}


	

	public CurrentAccount(double balance) {
		super();
		this.balance = balance;
	}

	public double getrate() {
		return rate;
	}

	public void setrate(float rate) {
		this.rate = rate;
	}

	public static float getCURRENRATE() {
		return CURRENTRATE;
	}

	public static void setCURRENTRATE(float CurrentRATE) {
		CURRENTRATE = CurrentRATE;
	}
}
