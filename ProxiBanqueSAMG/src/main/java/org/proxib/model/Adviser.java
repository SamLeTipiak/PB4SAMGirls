package org.proxib.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * <b>Adviser représente les différents conseillers d'une agence.</b>
 * <p>Chaque conseiller est caractérisé par :</p>
 * <ul>
 * <li>idAviser : un identifiant généré automatiquement (par incrémentation) au niveau de la base de données.</li>
 * <li>firstName : son prénom</li>
 * <li>lastName : son nom de famille</li>
 * <li>login : son login</li>
 * <li>password : son mot de passe</li>
 * </ul>
 * <p>De plus, chaque conseiller a aussi une liste de clients.
 * </p>
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania Bouzemame
 * @version 1.0
 *
 */
@Entity
public class Adviser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "idAdviser")
	private Long idAdviser;
	private String firstName;
	private String lastName;
	private String login, password;
	

	@OneToMany(mappedBy="adviser",cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<Client> clients = new ArrayList<Client>();

	
	
	// Méthodes 
	
	public void addClientToAdviser(Client client) {
		client.setAdviser(this);
		clients.add(client);
	}


	
	// Constructeurs 
	
	public Adviser(String firstName, String lastName, List<Client> clients, String login, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.clients = clients;
		this.login = login;
		this.password = password;
	}
	
	public Adviser(String firstName, String lastName, String login, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}
	
	public Adviser(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	public Adviser() {
		super();
	}

	
	// Getters Setters
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
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
	public Long getIdAdviser() {
		return idAdviser;
	}

	
	@Override
	public String toString() {
		return "Adviser [id=" + idAdviser + ", firstName=" + firstName + ", lastName=" + lastName + ", clients=" + clients
				+ "]";
	}

	


}
