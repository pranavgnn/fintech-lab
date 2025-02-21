package com.mit.controller;

import com.mit.entity.CustomerIdentification;
import com.mit.service.CustomerIdentificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-identification")
public class CustomerIdentificationController {
	
	 @Autowired
	 private CustomerIdentificationService customerIdentificationService;
	 
	 @GetMapping
	 public List<CustomerIdentification> getAllCustomerIdentifications() {
		 return customerIdentificationService.getAllCustomerIdentifications();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CustomerIdentification> getCustomerIdentificationById(@PathVariable Long id) {
		 return customerIdentificationService.getCustomerIdentificationById(id)
				 .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<CustomerIdentification> createCustomerIdentification(@RequestBody CustomerIdentification newCustomerIdentification) {
		 CustomerIdentification savedCustomerIdentification = customerIdentificationService.createCustomerIdentification(newCustomerIdentification);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CustomerIdentification> updateCustomerIdentification(@PathVariable Long id, @RequestBody CustomerIdentification newCustomerIdentification) {
		 try {
			 CustomerIdentification updatedCustomerIdentification = customerIdentificationService.updateCustomerIdentification(id, newCustomerIdentification);
			 return new ResponseEntity<>(updatedCustomerIdentification, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomerIdentification(@PathVariable Long id) {
		 try {
			 customerIdentificationService.deleteCustomerIdentification(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}