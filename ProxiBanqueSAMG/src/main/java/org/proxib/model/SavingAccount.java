package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SavingAccount extends Account {

	private static float SAVINGRATE = 0.03f;

	@OneToOne(mappedBy = "savingAccount", cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Client client;

	public SavingAccount() {
		super();
	}

	
	public SavingAccount(double balance) {
		super(balance);
		super.rate = SAVINGRATE;
	}


	public SavingAccount(double balance, double rate) {
		super(balance);
		super.rate = rate;
	}

	public double getrate() {
		return rate;
	}

	public void setrate(float rate) {
		this.rate = rate;
	}

	public static float getSAVINGRATE() {
		return SAVINGRATE;
	}

	public static void setSAVINGRATE(float sAVINGRATE) {
		SAVINGRATE = sAVINGRATE;
	}

}
