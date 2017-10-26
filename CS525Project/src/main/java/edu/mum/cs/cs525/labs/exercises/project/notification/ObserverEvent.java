package edu.mum.cs.cs525.labs.exercises.project.notification;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;

public class ObserverEvent {
	private Account account;
	private double amount;
	private String description;

	public ObserverEvent(Account account, double amount, String description) {
		this.account = account;
		this.amount = amount;
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}
}
