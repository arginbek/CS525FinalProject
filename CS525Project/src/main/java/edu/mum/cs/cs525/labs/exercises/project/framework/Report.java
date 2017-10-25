package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.time.LocalDate;

public class Report {
	String accountNumber;
	String userName;
	double incoming;
	double outcoming;
	double total;
	LocalDate start;
	LocalDate end;

	public Report(String accountNumber, String userName, double incoming, double outcoming, double total,
			LocalDate start, LocalDate end) {
		super();
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.incoming = incoming;
		this.outcoming = outcoming;
		this.total = total;
		this.start = start;
		this.end = end;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getIncoming() {
		return incoming;
	}

	public void setIncoming(double incoming) {
		this.incoming = incoming;
	}

	public double getOutcoming() {
		return outcoming;
	}

	public void setOutcoming(double outcoming) {
		this.outcoming = outcoming;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

}
