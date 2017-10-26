package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Account {
	private InterestType interestType;
	private Party customer;
	private String accountNumber;
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
	private double minThreshold = 0;
	private double balance;
	private ArrayList<AccountEntry> entries;

	public Account() {
		entries = new ArrayList<AccountEntry>();
	}
	
	public double getMinThreshold() {
		return minThreshold;
	}

	public void setMinThreshold(double minThreshold) {
		this.minThreshold = minThreshold;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<AccountEntry> getEntries() {
		return entries;
	}

	public Party getCustomer() {
		return customer;
	}

	public void setCustomer(Party customer) {
		this.customer = customer;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public InterestType getInterestType() {
		return interestType;
	}

	public void setInterestType(InterestType interestType) {
		this.interestType = interestType;
	}
	
	public void deposit(double val, String description) {
		this.balance = balance + val;
		AccountEntry entry = new AccountEntry();
		entry.setAccountName(this.getName());
		entry.setAccountNumber(this.getAccountNumber());
		entry.setDescription(description);
		entry.setValue(val);
		entry.setDate(LocalDate.now());
		entries.add(entry);
	};

	public void withdraw(double val, String description) {
		if (balance - val >= minThreshold) {
			this.balance = balance - val;
			AccountEntry entry = new AccountEntry();
			entry.setAccountName(this.getName());
			entry.setAccountNumber(this.getAccountNumber());
			entry.setDescription(description);
			entry.setValue(-val);
			entry.setDate(LocalDate.now());
			entries.add(entry);
		}
	}

	public void addInterest() {

		double val = this.interestType.calcInterest(this.getBalance());
		this.balance = this.balance + val;
		AccountEntry entry = new AccountEntry();
		entry.setAccountName(this.getName());
		entry.setAccountNumber(this.getAccountNumber());
		entry.setDescription("Interest");
		entry.setValue(val);
		entry.setDate(LocalDate.now());
		entries.add(entry);
	}

}
