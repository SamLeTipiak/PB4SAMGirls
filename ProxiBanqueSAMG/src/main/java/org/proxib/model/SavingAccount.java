package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * <b>SavingAccount représente les comptes épargne.</b>
 * <p>Chaque compte épargne a un taux de rémunération SAVINGRATE identique.
 * </p>
 * <p>Chaque compte épargne est aussi associé à un client.</p>
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania Bouzemame
 * @version 1.0
 *
 */
@Entity
public class SavingAccount extends Account {

	private static float SAVINGRATE = 0.03f;

	@OneToOne(mappedBy = "savingAccount", cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Client client;

	
	// Constructeurs 
	
	public SavingAccount(double balance, double rate) {
		super(balance);
		super.rate = rate;
	}
	
	public SavingAccount(double balance) {
		super(balance);
		super.rate = SAVINGRATE;
	}

	public SavingAccount() {
		super();
	}


	// Getters Setters

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
