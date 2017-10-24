package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AccountDAOImpl implements AccountDAO {
	Map<String, Account> accounts = new HashMap<String, Account>();

	public AccountDAOImpl() {

	}

	public void saveAccount(Account account) {
		if(account == null || account.getAccountNumber() == null)
			throw new IllegalArgumentException();
	}

	public void updateAccount(Account account) {
		// TODO Auto-generated method stub

	}

	public Account loadAccount(String accountnumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Account> getAccounts() {
		// TODO Auto-generated method stub
		return null;
	}
}
