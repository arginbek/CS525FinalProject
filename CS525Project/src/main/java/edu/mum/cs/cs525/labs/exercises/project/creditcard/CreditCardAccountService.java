package edu.mum.cs.cs525.labs.exercises.project.creditcard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.cs525.labs.exercises.project.bank.CreateFactoryBank;
import edu.mum.cs.cs525.labs.exercises.project.framework.Account;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountDAO;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountDAOImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountEntry;
import edu.mum.cs.cs525.labs.exercises.project.framework.AccountServiceImpl;
import edu.mum.cs.cs525.labs.exercises.project.framework.Company;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAbstractFactory;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;
import edu.mum.cs.cs525.labs.exercises.project.framework.Observable;
import edu.mum.cs.cs525.labs.exercises.project.framework.Person;
import edu.mum.cs.cs525.labs.exercises.project.framework.Report;
import edu.mum.cs.cs525.labs.exercises.project.framework.ReportType;

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
			report.add(new CreditReport(account.getAccountNumber(), account.getCustomer().getName(), totalDeposit,
					totalWithdraw, totalDeposit - totalWithdraw, start, end,
					((CreditCardInterestType) account.getInterestType())
							.getMinimumPayment(totalDeposit - totalWithdraw)));

		}

		return report;
	}

}
