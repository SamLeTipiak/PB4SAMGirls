package org.proxib.model;

import java.util.List;

public class Adviser {
	
	private Long id;
	private String firstName;
	private String lastName;
	private List<Client> clients;
	
	
	
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
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public Long getId() {
		return id;
	}
	public Adviser(String firstName, String lastName, List<Client> clients) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.clients = clients;
	}
	public Adviser() {
		super();
	}
	@Override
	public String toString() {
		return "Adviser [firstName=" + firstName + ", lastName=" + lastName + ", clients=" + clients + "]";
	}
	
	
	
	

}
