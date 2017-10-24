package edu.mum.cs.cs525.labs.exercises.project.bank;

import java.time.LocalDate;

public class PersonalAccount extends BankAccount {
	LocalDate birthdate;

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
}
