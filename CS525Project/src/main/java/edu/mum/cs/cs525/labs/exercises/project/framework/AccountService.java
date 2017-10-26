package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.List;

public interface AccountService {
	public void addInterest() ;
	public void createAccount(CreateAccountTO accountTO);
	public void deposit(String accountNumber, double val, String description);
	public void withdraw(String accountNumber, double val, String description);
	public List<? extends Account> getAccounts();
}
