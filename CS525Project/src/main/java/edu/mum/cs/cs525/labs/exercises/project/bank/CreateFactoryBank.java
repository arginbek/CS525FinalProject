package edu.mum.cs.cs525.labs.exercises.project.bank;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.InterestType;
import edu.mum.cs.cs525.labs.exercises.project.framework.Party;

public class CreateFactoryBank implements CreateAbstractFactory {
	private String interestType;
	private String accountName;
	private String accountType;
	private String customerType;
	public CreateFactoryBank(String interestType, String accountName, String customerType) {
		this.interestType=interestType;
		this.accountName=accountName;
		this.customerType=customerType;
	}
	public Account createAccount() {
		Account account = accountType=="" ? new PersonalAccount() : new CompanyAccount();
		account.setName(accountName);
		return account;
	}

	public Party createCustomer() {
		return null;
	}

	public InterestType createInterest() {
		// TODO Auto-generated method stub
		return null;
	}

}
