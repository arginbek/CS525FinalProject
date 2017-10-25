package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.List;

public interface AccountService extends Observable {
	public void addInterest() ;
	public void notifyObservers();
	public void createAccount(CreateAccountTO accountTO);
	public void deposit(Account account, double val, String description);
	public void withdraw(Account account, double val, String description);
	public List<? extends Account> getAccounts();
}
