package edu.mum.cs.cs525.labs.exercises.project.framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerDAOImpl implements CustomerDAO {
	Map<String, Party> customers = new HashMap<String, Party>();
	private static CustomerDAOImpl instance;
	private CustomerDAOImpl() {

	}
	public static CustomerDAOImpl getInstance() {
		if(instance ==null) {
			synchronized (CustomerDAOImpl.class) {
				if(instance==null) {
					instance = new CustomerDAOImpl();
				}
			}
		}
		return instance;
	}
	public void saveCustomer(Party customer) {
		if (customer == null || customer.getEmail() == null)
			throw new IllegalArgumentException();
		else
			customers.put(customer.getEmail(), customer);
	}

	public void updateCustomer(Party customer) {
		if (customer == null || customer.getEmail() == null)
			throw new IllegalArgumentException();
		else
		customers.put(customer.getEmail(), customer);
	}

	public Party loadCustomer(String email) {
		if (customers.containsKey(email))
			return customers.get(email);
		else
			return null;
	}

	public Collection<Party> getCustomers() {
		return customers.values();
	}
}
