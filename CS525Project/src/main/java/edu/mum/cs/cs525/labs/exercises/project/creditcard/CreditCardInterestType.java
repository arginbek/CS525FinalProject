package edu.mum.cs.cs525.labs.exercises.project.creditcard;

import edu.mum.cs.cs525.labs.exercises.project.framework.InterestType;

public abstract class CreditCardInterestType implements InterestType {

    public abstract double getMinimumPayment(double balance);
}
