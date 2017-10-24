package edu.mum.cs.cs525.labs.exercises.project.bank;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;

public class BankAccountService extends AccountServiceImpl {

	@Override
	public CreateAbstractFactory createFactory() {
		CreateFactoryBank cfb = new CreateFactoryBank("", "", "");
		return cfb;
	}

	@Override
	public boolean checkNotify(Account account, double val) {
		return false;
	}

}
