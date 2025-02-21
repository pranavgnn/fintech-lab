package com.mit.controller;

import com.mit.entity.CustomerProofOfId;
import com.mit.service.CustomerProofOfIdService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customer-proof-of-id")
public class CustomerProofOfIdController {
	
	 @Autowired
	 private CustomerProofOfIdService customerContactInformationService;
	 
	 @GetMapping
	 public List<CustomerProofOfId> getAllCustomerProofOfIds() {
		 return customerContactInformationService.getAllCustomerProofOfIds();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<CustomerProofOfId> getCustomerProofOfIdById(@PathVariable Long id) {
		 return customerContactInformationService.getCustomerProofOfIdById(id)
				 .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<CustomerProofOfId> createCustomerProofOfId(@RequestBody CustomerProofOfId newCustomerProofOfId) {
		 CustomerProofOfId savedCustomerIdentification = customerContactInformationService.createCustomerProofOfId(newCustomerProofOfId);
	 	return new ResponseEntity<>(savedCustomerIdentification, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<CustomerProofOfId> updateCustomerProofOfId(@PathVariable Long id, @RequestBody CustomerProofOfId newCustomerProofOfId) {
		 try {
			 CustomerProofOfId updatedCustomerIdentification = customerContactInformationService.updateCustomerProofOfId(id, newCustomerProofOfId);
			 return new ResponseEntity<>(updatedCustomerIdentification, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCustomerProofOfId(@PathVariable Long id) {
		 try {
			 customerContactInformationService.deleteCustomerProofOfId(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}