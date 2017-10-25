package edu.mum.cs.cs525.labs.exercises.project.creditcard;

import edu.mum.cs.cs525.labs.exercises.project.bank.CreateFactoryBank;
import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.Company;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;
import edu.mum.cs.cs525.labs.exercises.project.framework.Person;

public class CreditCardAccountService extends AccountServiceImpl {

	@Override
	public CreateAbstractFactory createFactory(CreateAccountTO accountTO) {
		CreateFactoryCreditCard cfc = new CreateFactoryCreditCard(accountTO);
		return cfc;
	}

	@Override
	public boolean checkNotify(Account account, double val) {
		if (account.getCustomer() instanceof Company)
			return true;
		else if (account.getCustomer() instanceof Person) {
			if (val > 400 || account.getBalance() < account.getMinThreshold())
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

}
