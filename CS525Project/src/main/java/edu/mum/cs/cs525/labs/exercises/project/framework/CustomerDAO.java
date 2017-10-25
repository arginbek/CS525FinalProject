package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.Collection;

public interface CustomerDAO {
	void saveCustomer(Party customer);

	void updateCustomer(Party customer);

	Party loadCustomer(String email);

	Collection<? extends Party> getCustomers();
}
