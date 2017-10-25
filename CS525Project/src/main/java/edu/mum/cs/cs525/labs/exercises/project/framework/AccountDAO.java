package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.Collection;
import java.util.List;

public interface AccountDAO {
	void saveAccount(Account account);

	void updateAccount(Account account);

	Account loadAccount(String accountnumber);

	List<? extends Account> getAccounts();
}
