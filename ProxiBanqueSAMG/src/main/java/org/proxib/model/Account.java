package org.proxib.model;

public class Account {

	private Long id;
	private double balance;
	private double rate;
	private Account.typeAccount typeAccount;

	public static enum typeAccount {
		CURRENT, SAVING
	}

	public Account() {
		super();
	}

	public Account(double balance, double rate, org.proxib.model.Account.typeAccount typeAccount) {
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

	public Account.typeAccount getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(Account.typeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}

}
