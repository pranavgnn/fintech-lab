package com.mit.controller;

import com.mit.entity.AddressType;
import com.mit.service.AddressTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/address-type")
public class AddressTypeController {
	
	 @Autowired
	 private AddressTypeService addressTypeService;
	 
	 @GetMapping
	 public List<AddressType> getAllAddressTypes() {
		 return addressTypeService.getAllAddressTypes();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<AddressType> getAddressTypeById(@PathVariable Long id) {
		 return addressTypeService.getAddressTypeById(id)
				 .map(addressType -> new ResponseEntity<>(addressType, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<AddressType> createAddressType(@RequestBody AddressType newAddressType) {
		 AddressType savedAddressType = addressTypeService.createAddressType(newAddressType);
	 	return new ResponseEntity<>(savedAddressType, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<AddressType> updateAddressType(@PathVariable Long id, @RequestBody AddressType newAddressType) {
		 try {
			 AddressType updatedAddressType = addressTypeService.updateAddressType(id, newAddressType);
			 return new ResponseEntity<>(updatedAddressType, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteAddressType(@PathVariable Long id) {
		 try {
			 addressTypeService.deleteAddressType(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}