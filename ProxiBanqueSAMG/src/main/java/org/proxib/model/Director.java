package org.proxib.model;

/**
 * <b>Director représente le directeur d'agence.</b>
 * <p>Il est caractérisé par :</p>
 * <ul>
 * <li>id : un identifiant </li>
 * <li>firstName : son prénom</li>
 * <li>lastName : son nom de famille</li>
 * </ul>
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania Bouzemame
 * @version 1.0
 *
 */
public class Director {

	private Long id;
	private String firstName;
	private String lastName;

	
	
	// Constructeurs
	
	
	public Director(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Director() {
		super();
	}


	// Getters Setters
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}

	
	@Override
	public String toString() {
		return "Director [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
	
	
}
