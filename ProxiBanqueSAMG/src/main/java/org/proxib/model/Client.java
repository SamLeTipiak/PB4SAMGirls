package org.proxib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
// @Component
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String email;

	// @ManyToOne(cascade={CascadeType.ALL})
	// @JoinColumn(name="adviser_id")
//	private Adviser adviser;

	@OneToOne( cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name="account_id")
	private Account savingAccount;
	
	@OneToOne( cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name="account_id")
	private Account currentAccount;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//
//	public Adviser getAdviser() {
//		return adviser;
//	}
//
//	public void setAdviser(Adviser adviser) {
//		this.adviser = adviser;
//	}


	public Long getId() {
		return id;
	}

	
	
//	 @Override
//	 public String toString() {
//	 return "Client [firstName=" + firstName + ", lastName=" + lastName + 
//	 "address=" + address + ", email=" + email
//	 + ", adviser=" + adviser + ", accounts=" + accounts + "]";
//	 }
	
	 public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Account getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(Account savingAccount) {
		this.savingAccount = savingAccount;
	}

	public Account getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}

	public Client(String firstName, String lastName, String address, String
	 email, Adviser adviser,
	 List<Account> accounts) {
	 super();
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.address = address;
	 this.email = email;
//	 this.adviser = adviser;
	 }

	 public Client(String firstName, String lastName, String address, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.email = email;
		}
	 
	public Client(String firstName, String lastName, String address, String email, Account currentAccount, Account savingAccount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}

	public Client() {
		super();
	}

//	@Override
//	public String toString() {
//		return "Client [firstName=" + firstName + ", lastName=" + lastName + "]";
//	}

	public void addCurrentAccountToClient(Account account) {
		account.setClient(this);
		this.setCurrentAccount(account);
	}
	
	public void addSavingAccountToClient(Account account) {
		account.setClient(this);
		this.setSavingAccount(account);
	}
	
}
