package edu.mum.cs.cs525.labs.exercises.project.creditcard;

import java.time.LocalDate;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;

public class CreditCardAccount extends Account {
	LocalDate expiryDate;

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

}
