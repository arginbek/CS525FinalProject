package edu.mum.cs.cs525.labs.exercises.project.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountDAO;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountDAOImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountEntry;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.Company;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;
import edu.mum.cs.cs525.labs.exercises.project.framework.Person;
import edu.mum.cs.cs525.labs.exercises.project.framework.Report;

public class BankAccountService extends AccountServiceImpl {
	AccountDAO accountDAO;

	public BankAccountService() {
		accountDAO = AccountDAOImpl.getInstance();
	}

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
			if (val > 500 || account.getBalance() < account.getMinThreshold())
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	public List<Report> getReport() {
		LocalDate lastMonth = LocalDate.now();
		LocalDate start = lastMonth.withDayOfMonth(1);
		LocalDate end = lastMonth.withDayOfMonth(lastMonth.lengthOfMonth());
		List<Report> report = new ArrayList<>();
        
		for (Account account : AccountDAOImpl.getInstance().getAccounts()) {
			double totalDeposit = 0;
			double totalWithdraw = 0;
			for (AccountEntry entry : account.getEntries()) {
				if (entry.getDate().isAfter(start) && entry.getDate().isBefore(end)) {
					if (entry.getValue() > 0)
						totalDeposit += entry.getValue();
					else
						totalWithdraw += entry.getValue();
				}
			}
			report.add(new Report(account.getAccountNumber(), account.getCustomer().getName(), totalDeposit,
					totalWithdraw, totalDeposit - totalWithdraw, start, end));
		}

		return report;
	}

}
