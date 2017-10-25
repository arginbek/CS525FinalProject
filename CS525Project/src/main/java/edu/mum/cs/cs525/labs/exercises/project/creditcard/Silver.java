package edu.mum.cs.cs525.labs.exercises.project.creditcard;

public class Silver extends CreditCardInterestType {

	@Override
	public double getMinimumPayment(double balance) {
		return 0.12 * balance;
	}

	@Override
	public double calcInterest(double balance) {
		return 0.8 * balance;
	}

}
