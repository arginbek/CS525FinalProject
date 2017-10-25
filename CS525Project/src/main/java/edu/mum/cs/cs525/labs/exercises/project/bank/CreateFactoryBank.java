package edu.mum.cs.cs525.labs.exercises.project.bank;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.framework.Company;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;
import edu.mum.cs.cs525.labs.exercises.project.framework.InterestType;
import edu.mum.cs.cs525.labs.exercises.project.framework.Party;
import edu.mum.cs.cs525.labs.exercises.project.framework.Person;

public class CreateFactoryBank implements CreateAbstractFactory {
	private BankCreateAccountTO accountTO;

	public CreateFactoryBank(CreateAccountTO accountTO) {
		super();
		this.accountTO = ((BankCreateAccountTO) accountTO);
	}

	public Account createAccount() {

		if (accountTO.getAccountType() == AccountType.company) {
			CompanyAccount account;
			account = new CompanyAccount();
			account.setNumberOfEmployees(accountTO.getNumberOfEmployee());
			account.setName(accountTO.getName());
			account.setAccountNumber(accountTO.getAccountNumber());
			account.setStreet(accountTO.getStreet());
			account.setCity(accountTO.getCity());
			account.setState(accountTO.getState());
			account.setZip(accountTO.getZip());
			account.setEmail(accountTO.getEmail());

			return account;
		} else {
			PersonalAccount account;
			account = new PersonalAccount();
			account.setEmail(accountTO.getEmail());
			account.setName(accountTO.getName());
			account.setAccountNumber(accountTO.getAccountNumber());
			account.setStreet(accountTO.getStreet());
			account.setCity(accountTO.getCity());
			account.setState(accountTO.getState());
			account.setZip(accountTO.getZip());
			account.setEmail(accountTO.getEmail());
			account.setBirthdate(accountTO.getBirthDate());

			return account;
		}

	}

	public Party createCustomer() {
		Party party;
		if (accountTO.getAccountType().equals("company")) {
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
		if (accountTO.getInterestType().equals("checking"))
			return new CheckingInterest();
		else
			return new SavingInterest();
	}

}
