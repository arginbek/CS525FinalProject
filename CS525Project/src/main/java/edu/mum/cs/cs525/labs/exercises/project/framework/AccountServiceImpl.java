package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.List;

public abstract class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private CustomerDAO customerDAO;

	public AccountServiceImpl() {
		accountDAO = new AccountDAOImpl();
		customerDAO = new CustomerDAOImpl();
	}

	public void addInterest() {
		accountDAO.getAccounts().forEach(acct -> acct.addInterest());
	}

	public void createAccount(CreateAccountTO accountTO) {
		CreateAbstractFactory caf = this.createFactory(accountTO);
		Account acct = caf.createAccount();
		Party party = caf.createCustomer();
		InterestType interestType = caf.createInterest();
		acct.setInterestType(interestType);
		Party customer = customerDAO.loadCustomer(party.getEmail());
		if (customer == null)
			customerDAO.saveCustomer(party);
		else
			acct.setCustomer(customer);
		accountDAO.saveAccount(acct);
	}

	public void deposit(Account account, double val, String description) {
		account.deposit(val, description);
		accountDAO.updateAccount(account);
		if (checkNotify(account, val))
			notifyObservers();
	}

	public void withdraw(Account account, double val, String description) {
		account.withdraw(val, description);
		accountDAO.updateAccount(account);
		if (checkNotify(account, val))
			notifyObservers();
	}

	public void notifyObservers() {

	}
	
	public List<? extends Account> getAccounts(){
		return accountDAO.getAccounts();
	}

	public abstract CreateAbstractFactory createFactory(CreateAccountTO accountTO);

	public abstract boolean checkNotify(Account account, double val);
}
