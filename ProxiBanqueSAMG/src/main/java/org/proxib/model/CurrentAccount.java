package org.proxib.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * <b>CurrentAccount représente les comptes courants.</b>
 * <p>Chaque compte courant a un taux de rémunération CURRENTRATE identique.
 * </p>
 * <p>Chaque compte épargne est aussi associé à un client.</p>
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania Bouzemame
 * @version 1.0
 *
 */
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
