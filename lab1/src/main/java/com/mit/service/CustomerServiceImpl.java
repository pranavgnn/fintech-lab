package com.mit.service;

import com.mit.entity.Customer;
import com.mit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	 @Autowired
	 private CustomerRepository customerRepository;
		 @Override
		 public List<Customer> getAllCustomers() {
		 return customerRepository.findAll();
	 }
		 
	 @Override
	 public Optional<Customer> getCustomerById(Long id) {
		 return customerRepository.findById(id);
	 }
	 
	 @Override
	 public Customer createCustomer(Customer customer) {
		 return customerRepository.save(customer);
	 }
	 
	 @Override
	 public Customer updateCustomer(Long id, Customer customerDetails) {
		 return customerRepository.findById(id).map(customer -> {
			customer.setFirstName(customerDetails.getFirstName());
			customer.setLastName(customerDetails.getLastName());
			customer.setEmail(customerDetails.getEmail());
			customer.setPhoneNumber(customerDetails.getPhoneNumber());
			customer.setAddress(customerDetails.getAddress());
			customer.setDateOfBirth(customerDetails.getDateOfBirth());
			return customerRepository.save(customer);
	 }).orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
	}
	 
	 @Override
	 public void deleteCustomer(Long id) {
		 customerRepository.findById(id).ifPresentOrElse(
				 customerRepository::delete,
				 () -> {
					 throw new RuntimeException("Item not found with id: " + id);
				 }
		);
	 }
}
