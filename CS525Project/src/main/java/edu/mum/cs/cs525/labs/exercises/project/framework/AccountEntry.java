package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.time.LocalDate;

public class AccountEntry {
	String accountNumber;
	String accuntName;
	double value;
	String description;
	LocalDate date;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccuntName() {
		return accuntName;
	}

	public void setAccuntName(String accuntName) {
		this.accuntName = accuntName;
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
