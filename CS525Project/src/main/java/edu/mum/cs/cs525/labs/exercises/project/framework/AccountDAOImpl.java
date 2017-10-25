package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDAOImpl implements AccountDAO {
	private static AccountDAO instance;
	Map<String, Account> accounts = new HashMap<String, Account>();

	private AccountDAOImpl() {

	}

	public static AccountDAO getInstance() {
		if (instance == null) {
			synchronized (AccountDAOImpl.class) {
				if (instance == null)
					instance = new AccountDAOImpl();
			}
		}

		return instance;
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

	public List<Account> getAccounts() {
		return new ArrayList<>(accounts.values());
	}
}
