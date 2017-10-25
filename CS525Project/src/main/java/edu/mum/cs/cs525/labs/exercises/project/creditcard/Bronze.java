package edu.mum.cs.cs525.labs.exercises.project.creditcard;


public class Bronze extends CreditCardInterestType {

	@Override
	public double getMinimumPayment(double balance) {
		return 0.14 * balance;
	}

	@Override
	public double calcInterest(double balance) {
		return 0.10 * balance;
	}

}
