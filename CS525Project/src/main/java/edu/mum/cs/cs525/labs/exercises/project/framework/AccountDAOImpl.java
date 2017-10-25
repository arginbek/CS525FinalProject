package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AccountDAOImpl implements AccountDAO {
	Map<String, Account> accounts = new HashMap<String, Account>();

	public AccountDAOImpl() {

	}

	public void saveAccount(Account account) {
		if (account == null || account.getAccountNumber() == null)
			throw new IllegalArgumentException();
		else
			accounts.put(account.getAccountNumber(), account);
	}

	public void updateAccount(Account account) {
		if (account == null || account.getAccountNumber() == null)
			throw new IllegalArgumentException();
		else
		accounts.put(account.getAccountNumber(), account);
	}

	public Account loadAccount(String accountnumber) {
		if (accounts.containsKey(accountnumber))
			return accounts.get(accountnumber);
		else
			return null;
	}

	public Collection<Account> getAccounts() {
		return accounts.values();
	}

	@Override
	public Party loadCustomer(String email) {
		if (accounts.containsKey(email))
			return accounts.get(email).getCustomer();
		else
			return null;
	}
}
