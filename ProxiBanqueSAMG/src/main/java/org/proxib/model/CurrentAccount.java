package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CurrentAccount extends Account{
	
	private static float CURRENTRATE=0.00f;

	
	@OneToOne(mappedBy="currentAccount", cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Client client;
	
	
	
	public CurrentAccount() {
		super();
	}

	public CurrentAccount(double balance) {
		super(balance);
		super.rate = CURRENTRATE;
	}


	public CurrentAccount(double balance, double rate) {
		super(balance);
		super.rate = rate;
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
