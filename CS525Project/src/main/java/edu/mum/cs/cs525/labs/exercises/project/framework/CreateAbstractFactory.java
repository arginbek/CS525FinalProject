package edu.mum.cs.cs525.labs.exercises.project.framework;

public interface CreateAbstractFactory {
	public Account createAccount();
	public Party createCustomer();
	public InterestType createInterest();
}
