package com.mit.controller;

import com.mit.entity.User;
import com.mit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	 @Autowired
	 private UserService userService;
	 
	 @GetMapping
	 public List<User> getAllUsers(
			 @RequestParam(name = "page", required = false, defaultValue = "0") String page,
			 @RequestParam(name = "sort", required = false, defaultValue = "unsorted") String order
	 ) {
		 return userService.getSortedUsers(order);
//		 return userService.getPagedAndSortedUsers(page, order);
	 }

	 @GetMapping("/{id}")
	 public ResponseEntity<User> getUserById(@PathVariable Long id) {
		 return userService.getUserById(id)
				 .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
				 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PostMapping
	 public ResponseEntity<User> createUser(@RequestBody User newUser) {
		 User savedUser = userService.createUser(newUser);
	 	return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUser) {
		 try {
			 User updatedUser = userService.updateUser(id, newUser);
			 return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		 try {
			 userService.deleteUser(id);
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 } catch (RuntimeException e) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	 }
}