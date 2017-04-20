package org.proxib.model;

public class Director {

	private Long id;
	private String firstName;
	private String lastName;
	
	
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
	public Director(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Director() {
		super();
	}
	@Override
	public String toString() {
		return "Director [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
	
	
}
