package org.proxib.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Client implements Serializable{

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
	// private Adviser adviser;

	// @OneToMany(mappedBy="client", cascade={CascadeType.ALL},
	// fetch=FetchType.EAGER)
	// private List<Account> comptes;

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

	// public Adviser getAdviser() {
	// return adviser;
	// }
	// public void setAdviser(Adviser adviser) {
	// this.adviser = adviser;
	// }
	// public List<Account> getComptes() {
	// return comptes;
	// }
	// public void setComptes(List<Account> comptes) {
	// this.comptes = comptes;
	// }
	public Long getId() {
		return id;
	}

	// @Override
	// public String toString() {
	// return "Client [firstName=" + firstName + ", lastName=" + lastName + ",
	// address=" + address + ", email=" + email
	// + ", adviser=" + adviser + ", comptes=" + comptes + "]";
	// }
	//
	// public Client(String firstName, String lastName, String address, String
	// email, Adviser adviser,
	// List<Account> comptes) {
	// super();
	// this.firstName = firstName;
	// this.lastName = lastName;
	// this.address = address;
	// this.email = email;
	// this.adviser = adviser;
	// this.comptes = comptes;
	// }

	public Client(String firstName, String lastName, String address, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
