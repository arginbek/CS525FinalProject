package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.List;

import edu.mum.cs.cs525.labs.exercises.project.notification.AbstractObservable;
import edu.mum.cs.cs525.labs.exercises.project.notification.ObserverEvent;

public abstract class AccountServiceImpl extends AbstractObservable<Party> implements AccountService {
	private AccountDAO accountDAO;
	private CustomerDAO customerDAO;

	public AccountServiceImpl() {
		accountDAO = AccountDAOImpl.getInstance();
		customerDAO = CustomerDAOImpl.getInstance();
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
		if (customer == null) {
			customerDAO.saveCustomer(party);
			acct.setCustomer(party);
		} else {
			acct.setCustomer(customer);
		}
		accountDAO.saveAccount(acct);
	}

	public void deposit(String accountNumber, double val, String description) {
		Account account = getAccount(accountNumber);
		account.deposit(val, description);
		accountDAO.updateAccount(account);
		if (checkNotify(account, val)) {
			this.addObserver(account.getCustomer());
			notifyAllObservers(account.getCustomer(), new ObserverEvent(account, val, description));//account, val, description
		}
	}

	public void withdraw(String accountNumber, double val, String description) {
		Account account = getAccount(accountNumber);
		account.withdraw(val, description);
		accountDAO.updateAccount(account);
		if (checkNotify(account, val)) {
			this.addObserver(account.getCustomer());
			notifyAllObservers(account.getCustomer(), new ObserverEvent(account, val, description));
		}
	}

	public Account getAccount(String accountNumber) {
		return accountDAO.loadAccount(accountNumber);
	}

	public List<? extends Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	public abstract CreateAbstractFactory createFactory(CreateAccountTO accountTO);

	public abstract boolean checkNotify(Account account, double val);
}
