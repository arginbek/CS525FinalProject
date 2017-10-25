package edu.mum.cs.cs525.labs.exercises.project.bank;

import java.time.LocalDate;

import javax.lang.model.type.IntersectionType;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.Company;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.InterestType;
import edu.mum.cs.cs525.labs.exercises.project.framework.Party;
import edu.mum.cs.cs525.labs.exercises.project.framework.Person;

public class CreateFactoryBank implements CreateAbstractFactory {
	private InterestTypeEnum interestType;
	private String accountNumber;
	private String accountName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
	private LocalDate birthDate;
	private Integer numberOfEmp;
	private AccountType accountType;
	private String customerType;

	public CreateFactoryBank(InterestTypeEnum interestType, String accountNumber, String accountName, String street,
			String city, String state, String zip, String email, LocalDate birthDate, AccountType accountType,
			String customerType, Integer numberOfEmp) {
		super();
		this.interestType = interestType;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.birthDate = birthDate;
		this.accountType = accountType;
		this.customerType = customerType;
		this.numberOfEmp = numberOfEmp;
	}

	public Account createAccount() {

		if (accountType == AccountType.company) {
			CompanyAccount account;
			account = new CompanyAccount();
			account.setNumberOfEmployees(numberOfEmp);
			account.setName(accountName);
			account.setAccountNumber(accountNumber);
			account.setStreet(street);
			account.setCity(city);
			account.setState(state);
			account.setZip(zip);
			account.setEmail(email);

			return account;
		} else {
			PersonalAccount account;
			account = new PersonalAccount();
			account.setName(accountName);
			account.setAccountNumber(accountNumber);
			account.setStreet(street);
			account.setCity(city);
			account.setState(state);
			account.setZip(zip);
			account.setEmail(email);
			account.setBirthdate(birthDate);

			return account;
		}

	}

	public Party createCustomer() {
		return null;
	}

	public InterestType createInterest() {
		// TODO Auto-generated method stub
		return null;
	}

}
