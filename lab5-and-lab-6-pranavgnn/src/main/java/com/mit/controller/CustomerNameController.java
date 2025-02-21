package com.mit.controller;

import com.mit.entity.CustomerName;
import com.mit.service.CustomerNameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-name")
public class CustomerNameController {
	
	 @Autowired
	 private CustomerNameService customerContactInformationService;
	 
	 @GetMapping
	 public List<CustomerName> getAllCustomerNames() {
		 return customerContactInformationService.getAllCustomerNames();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CustomerName> getCustomerNameById(@PathVariable Long id) {
		 return customerContactInformationService.getCustomerNameById(id)
				 .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<CustomerName> createCustomerName(@RequestBody CustomerName newCustomerName) {
		 CustomerName savedCustomerIdentification = customerContactInformationService.createCustomerName(newCustomerName);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CustomerName> updateCustomerName(@PathVariable Long id, @RequestBody CustomerName newCustomerName) {
		 try {
			 CustomerName updatedCustomerIdentification = customerContactInformationService.updateCustomerName(id, newCustomerName);
			 return new ResponseEntity<>(updatedCustomerIdentification, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomerName(@PathVariable Long id) {
		 try {
			 customerContactInformationService.deleteCustomerName(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}