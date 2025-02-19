package com.mit.controller;

import com.mit.entity.UserAddress;
import com.mit.service.UserAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user-address")
public class UserAddressController {
	
	 @Autowired
	 private UserAddressService userAddressService;
	 
	 @GetMapping
	 public List<UserAddress> getAllUserAddresses() {
		 return userAddressService.getAllUserAddresses();
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<UserAddress> getUserAddressById(@PathVariable Long id) {
		 return userAddressService.getUserAddressById(id)
				 .map(userAddress -> new ResponseEntity<>(userAddress, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<UserAddress> createUserAddress(@RequestBody UserAddress newUserAddress) {
		 UserAddress savedUser = userAddressService.createUserAddress(newUserAddress);
	 	return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<UserAddress> updateUserAddress(@PathVariable Long id, @RequestBody UserAddress newUserAddress) {
		 try {
			 UserAddress updatedUser = userAddressService.updateUserAddress(id, newUserAddress);
			 return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteUserAddress(@PathVariable Long id) {
		 try {
			 userAddressService.deleteUserAddress(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}