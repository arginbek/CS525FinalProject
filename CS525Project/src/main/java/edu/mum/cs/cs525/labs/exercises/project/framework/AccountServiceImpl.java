package edu.mum.cs.cs525.labs.exercises.project.framework;

public abstract class AccountServiceImpl  implements AccountService{

	public void addInterest(Account account) {
		account.getInterestType().calcInterest(account.getBalance());
	}

	public void createAccount(Account account) {
		CreateAbstractFactory caf = this.createFactory(account);
		Account acct = caf.createAccount();
		Party party = caf.createCustomer();
		InterestType interestType = caf.createInterest();
		acct.setInterestType(interestType);
		acct.setCustomer(party);
	}

	public void deposit(Account account, double val) {
		account.deposit(val);
		if (checkNotify(account, val))
			notifyObservers();
		
	}
	

	public void withdraw(Account account, double val) {
		account.withdraw(val);
		if (checkNotify(account, val))
			notifyObservers();
	}

	public void notifyObservers() {
		
	}

	public abstract CreateAbstractFactory createFactory(Account account);
	public abstract boolean checkNotify(Account account, double val);
}
