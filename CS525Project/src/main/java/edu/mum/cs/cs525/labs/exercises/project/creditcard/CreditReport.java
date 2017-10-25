package edu.mum.cs.cs525.labs.exercises.project.creditcard;

import java.time.LocalDate;

import edu.mum.cs.cs525.labs.exercises.project.framework.Report;;

public class CreditReport extends Report {
	double minimumPayment;

	public CreditReport(String accountNumber, String userName, double incoming, double outcoming, double total,
			LocalDate start, LocalDate end, double minimumPayment) {
		super(accountNumber, userName, incoming, outcoming, total, start, end);
		this.minimumPayment = minimumPayment;
	}

	public CreditReport(Report report, double minimumPayment) {
		super(report.getAccountNumber(), report.getUserName(), report.getIncoming(), report.getOutcoming(),
				report.getTotal(), report.getStart(), report.getEnd());
		this.minimumPayment = minimumPayment;
	}

}
