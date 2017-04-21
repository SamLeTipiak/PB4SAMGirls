package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SavingAccount  {

	private static float SAVINGRATE = 0.03f;
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

	

	@OneToOne(mappedBy = "savingAccount", cascade = CascadeType.ALL)
	private Client client;



	
	public static float getSAVINGRATE() {
		return SAVINGRATE;
	}

	public static void setSAVINGRATE(float sAVINGRATE) {
		SAVINGRATE = sAVINGRATE;
	}

	public SavingAccount(double balance) {
		super();
		this.balance = balance;
	}

	public SavingAccount() {
		super();
	}

	@Override
	public String toString() {
		return "SavingAccount [balance=" + balance + "]";
	}

}
