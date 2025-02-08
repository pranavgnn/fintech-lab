package com.mit.controller;

import com.mit.entity.CustomerDetails;
import com.mit.service.CustomerDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-details")
public class CustomerDetailsController {
	
	 @Autowired
	 private CustomerDetailsService customerDetailsService;
	 
	 @GetMapping
	 public List<CustomerDetails> getAllCustomersDetails() {
		 return customerDetailsService.getAllCustomersDetails();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CustomerDetails> getCustomerDetailsById(@PathVariable Long id) {
		 return customerDetailsService.getCustomerDetailsById(id)
				 .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<CustomerDetails> createCustomerDetails(@RequestBody CustomerDetails customerDetails) {
	 CustomerDetails savedCustomer = customerDetailsService.createCustomerDetails(customerDetails);
	 	return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CustomerDetails> updateCustomer(@PathVariable Long id, @RequestBody CustomerDetails customerDetails) {
		 try {
			 CustomerDetails updatedCustomer = customerDetailsService.updateCustomerDetails(id, customerDetails);
			 return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		 try {
			 customerDetailsService.deleteCustomerDetails(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}