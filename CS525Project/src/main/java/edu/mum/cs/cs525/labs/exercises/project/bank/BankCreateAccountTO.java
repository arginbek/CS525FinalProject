package edu.mum.cs.cs525.labs.exercises.project.bank;

import java.time.LocalDate;

import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;

public class BankCreateAccountTO extends CreateAccountTO {
	private int numberOfEmployee;
	private LocalDate birthDate;
	private AccountType accountType;
	
	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}
	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
}
