package edu.mum.cs.cs525.labs.exercises.project.creditcard;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.framework.Company;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;
import edu.mum.cs.cs525.labs.exercises.project.framework.InterestType;
import edu.mum.cs.cs525.labs.exercises.project.framework.Party;
import edu.mum.cs.cs525.labs.exercises.project.framework.Person;

public class CreateFactoryCreditCard implements CreateAbstractFactory {
	private CreditCardCreateAccountTO accountTO;

	public CreateFactoryCreditCard(CreateAccountTO accountTO) {
		super();
		this.accountTO = ((CreditCardCreateAccountTO) accountTO);
	}

	public Account createAccount() {
		CreditCardAccount account;
		account = new CreditCardAccount();
		account.setExpiryDate(accountTO.getExpDate());
		account.setName(accountTO.getName());
		account.setAccountNumber(accountTO.getAccountNumber());
		account.setStreet(accountTO.getStreet());
		account.setCity(accountTO.getCity());
		account.setState(accountTO.getState());
		account.setZip(accountTO.getZip());
		account.setEmail(accountTO.getEmail());
		return account;
	}

	public Party createCustomer() {
		Party party;
		if (accountTO.getAccountType() == AccountType.company) {
			party = new Company();
		} else {
			party = new Person();
		}
		party.setEmail(accountTO.getEmail());
		party.setName(accountTO.getName());
		party.setStreet(accountTO.getStreet());
		party.setCity(accountTO.getCity());
		party.setState(accountTO.getState());
		party.setZip(accountTO.getZip());
		party.setEmail(accountTO.getEmail());
		return party;
	}

	public InterestType createInterest() {
		if (accountTO.getInterestType().equals("gold"))
			return new Gold();
		else if(accountTO.getInterestType().equals("silver"))
			return new Silver();
		else
			return new Bronze();
	}

}