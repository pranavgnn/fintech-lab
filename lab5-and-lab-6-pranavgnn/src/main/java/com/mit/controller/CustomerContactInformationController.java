package com.mit.controller;

import com.mit.entity.CustomerContactInformation;
import com.mit.service.CustomerContactInformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-contact-information")
public class CustomerContactInformationController {
	
	 @Autowired
	 private CustomerContactInformationService customerContactInformationService;
	 
	 @GetMapping
	 public List<CustomerContactInformation> getAllCustomerContactInformations() {
		 return customerContactInformationService.getAllCustomerContactInformations();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CustomerContactInformation> getCustomerIdentificationById(@PathVariable Long id) {
		 return customerContactInformationService.getCustomerContactInformationById(id)
				 .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<CustomerContactInformation> createCustomerContactInformation(@RequestBody CustomerContactInformation newCustomerIdentification) {
		 CustomerContactInformation savedCustomerIdentification = customerContactInformationService.createCustomerContactInformation(newCustomerIdentification);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CustomerContactInformation> updateCustomerContactInformation(@PathVariable Long id, @RequestBody CustomerContactInformation newCustomerIdentification) {
		 try {
			 CustomerContactInformation updatedCustomerIdentification = customerContactInformationService.updateCustomerContactInformation(id, newCustomerIdentification);
			 return new ResponseEntity<>(updatedCustomerIdentification, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomerContactInformation(@PathVariable Long id) {
		 try {
			 customerContactInformationService.deleteCustomerContactInformation(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}