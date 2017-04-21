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
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

//@Entity
// @Component
public class Client2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String email;

	// @ManyToOne(cascade={CascadeType.ALL})
	// @JoinColumn(name="adviser_id")
//	private Adviser adviser;

	
	private Account a1;
	private Account a2;

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




	public Client2(Long id, String firstName, String lastName, String address, String email, Account2 a1, Account a2) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.email = email;
//	this.a1 = new Account2;
	this.a2 = a2;
}

	public Client2(String firstName, String lastName, String address, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}

	public Client2() {
		super();
	}



	
}
