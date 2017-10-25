package edu.mum.cs.cs525.labs.exercises.project.bank;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.Company;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;
import edu.mum.cs.cs525.labs.exercises.project.framework.Party;
import edu.mum.cs.cs525.labs.exercises.project.framework.Person;
import edu.mum.cs.cs525.labs.exercises.project.ui.bank.BankFrm;

public class BankAccountService extends AccountServiceImpl {

	@Override
	public CreateAbstractFactory createFactory(CreateAccountTO accountTO) {
		CreateFactoryBank cfb = new CreateFactoryBank(accountTO);
		return cfb;
	}

	@Override
	public boolean checkNotify(Account account, double val) {
		if (account.getCustomer() instanceof Company)
			return true;
		else if (account.getCustomer() instanceof Person) {
			if (val > 500 || account.getBalance() < 0)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

}
