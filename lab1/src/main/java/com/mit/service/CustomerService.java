package com.mit.service;

import com.mit.entity.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
	 List<Customer> getAllCustomers();
	 Optional<Customer> getCustomerById(Long id);
	 Customer createCustomer(Customer customer);
	 Customer updateCustomer(Long id, Customer customerDetails);
	 void deleteCustomer(Long id);
}