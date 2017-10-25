package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.time.LocalDate;

public class AccountEntry {
	Account account;
	double value;
	String description;
	LocalDate date;

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
