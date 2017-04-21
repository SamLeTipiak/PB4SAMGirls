package org.proxib.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
//@Component
public class Adviser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="adviser",cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
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
	
	public Adviser(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Adviser() {
		super();
	}
	
	@Override
	public String toString() {
		return "Adviser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", clients=" + clients
				+ "]";
	}

	
	

}
