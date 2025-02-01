package com.mit.controller;

import com.mit.entity.Customer;
import com.mit.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	 @Autowired
	 private CustomerService customerService;
	 
	 @GetMapping
	 public List<Customer> getAllCustomers() {
		 return customerService.getAllCustomers();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		 return customerService.getCustomerById(id)
				 .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	 Customer savedCustomer = customerService.createCustomer(customer);
	 	return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
		 try {
			 Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
			 return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		 try {
			 customerService.deleteCustomer(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}