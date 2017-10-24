package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.beans.Customizer;

public abstract class AccountServiceImpl  implements AccountService{

	public void addInterest(Account account) {
		
	}

	public void createAccount(Account account) {
		CreateAbstractFactory caf = this.createFactory();
		Account acct = caf.createAccount();
		Party party = caf.createCustomer();
		InterestType interestType = caf.createInterest();
		acct.setInterestType(interestType);
		acct.setCustomer(party);
		//
	}
	
	public abstract CreateAbstractFactory createFactory();

	public void deposit(Account account, double val) {
		account.deposit();
		if (checkNotify(account, val))
			notifyObservers();
		
	}
	public abstract boolean checkNotify(Account account, double val);

	public void withdraw(Account account, double val) {
		account.withdraw();
		if (checkNotify(account, val))
			notifyObservers();
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
	
}
