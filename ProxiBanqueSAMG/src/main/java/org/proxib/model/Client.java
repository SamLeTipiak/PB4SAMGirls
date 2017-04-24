package org.proxib.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * <b>Client représente les clients de la banque.</b>
 * <p>
 * Chaque client est caractérisé par les informations suivantes :
 * <ul>
 * <li>id : un identifiant généré automatiquement (par incrémentation à partir
 * de 1) par la base de données</li>
 * <li>firstName : son prénom</li>
 * <li>lastName : son nom de famille</li>
 * <li>adresse : son adresse physique</li>
 * <li>email : son adresse mail</li>
 * </ul>
 * </p>
 * <p>
 * Chaque client est aussi associé à un conseiller et à un compte courant et/ou
 * épargne qu'il est possible de modifier.
 * </p>
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Entity
// @Component
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "idClient")
	private Long idClient;
	private String firstName;
	private String lastName;
	private String address;
	private String email;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "adviser_id")
	private Adviser adviser;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "savingAccount_id")
	private SavingAccount savingAccount;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "currentAccount_id")
	private CurrentAccount currentAccount;

	
	// Constructeurs
	
	public Client(String lastName, String firstName, String address, String email, Adviser adviser,
			List<Account> accounts) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.adviser = adviser;
	}

	public Client(String lastName, String firstName, String address, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}

	 public Client(String lastName, String firstName, String address, String
	 email, SavingAccount savingAccount) {
	 super();
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.address = address;
	 this.email = email;
	 this.savingAccount = savingAccount;
	 }

	public Client() {
		super();
	}

	
	// Getters Setters
	
	
	
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

	public Adviser getAdviser() {
		return adviser;
	}

	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}

	public Long getIdClient() {
		return idClient;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public SavingAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}


	// Méthodes particulières

	/**
	 * addCurrentAccountToClient() permet d'associer un compte courant à un
	 * client donné.
	 * 
	 * @param account
	 */
	public void addCurrentAccountToClient(CurrentAccount account) {
		account.setClient(this);
		this.setCurrentAccount(account);
	}

	/**
	 * addSavingtAccountToClient() permet d'associer un compte épargne à un
	 * client donné.
	 * 
	 * @param account
	 */
	public void addSavingAccountToClient(SavingAccount account) {
		account.setClient(this);
		this.setSavingAccount(account);
	}
	
	@Override
	public String toString() {
		if (firstName == null) {
			return "";
		}
		return firstName + " " + lastName;
	}

}
