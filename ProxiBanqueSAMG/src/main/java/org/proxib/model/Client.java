package org.proxib.model;

import java.util.List;

public class Client {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String adresse;
	private String email;
	private Adviser adviser;
	private List<Account> comptes;
	
	
	
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public List<Account> getComptes() {
		return comptes;
	}
	public void setComptes(List<Account> comptes) {
		this.comptes = comptes;
	}
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + ", adresse=" + adresse + ", email=" + email
				+ ", adviser=" + adviser + ", comptes=" + comptes + "]";
	}
	
	public Client(String firstName, String lastName, String adresse, String email, Adviser adviser,
			List<Account> comptes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresse = adresse;
		this.email = email;
		this.adviser = adviser;
		this.comptes = comptes;
	}
	public Client() {
		super();
	}
	
	
	
	

}
