package edu.mum.cs.cs525.labs.exercises.project.creditcard;


public class Gold extends CreditCardInterestType {

	@Override
	public double getMinimumPayment(double balance) {
		return 0.10 * balance;
	}

	@Override
	public double calcInterest(double balance) {
		return 0.6 * balance;
	}

}
