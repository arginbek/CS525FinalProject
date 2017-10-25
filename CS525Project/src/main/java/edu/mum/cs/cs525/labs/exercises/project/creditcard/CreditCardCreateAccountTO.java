package edu.mum.cs.cs525.labs.exercises.project.creditcard;

import java.time.LocalDate;
import edu.mum.cs.cs525.labs.exercises.project.framework.CreateAccountTO;

public class CreditCardCreateAccountTO extends CreateAccountTO {
	private LocalDate expDate;

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
}
