package edu.mum.cs.cs525.labs.exercises.project.bank;

import edu.mum.cs.cs525.labs.exercises.project.framework.InterestType;

public class SavingInterest implements InterestType {

	public double calcInterest(double pBalance) {
		return 0.01 * pBalance;
	}

	

}
