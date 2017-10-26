package edu.mum.cs.cs525.labs.exercises.project.framework;

import edu.mum.cs.cs525.labs.exercises.project.notification.Observer;
import edu.mum.cs.cs525.labs.exercises.project.notification.ObserverEvent;

public abstract class Party implements Observer<Party> {
	protected String name;
	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	protected String email;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void update(Party o, ObserverEvent eventType) {
		String content = "Transaction description: " + eventType.getDescription() + 
				" Transaction amount: " + eventType.getAmount() + 
				" Account number: " + eventType.getAccount().getAccountNumber();
		sendEmail(content);
	}

	private void sendEmail(String content) {
		System.out.println(content);
	}
}
