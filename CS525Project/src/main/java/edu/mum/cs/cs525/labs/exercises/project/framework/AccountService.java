package edu.mum.cs.cs525.labs.exercises.project.framework;

public interface AccountService extends Observable {
	public void addInterest(Account account) ;
	public void notifyObservers();
	public void createAccount(Account account);
	public void deposit(Account account, double val);
	public void withdraw(Account account, double val);
}
