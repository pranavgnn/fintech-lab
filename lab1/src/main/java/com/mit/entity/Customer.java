package com.mit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private String phoneNumber;
	 private String address;
	 private String dateOfBirth;
	 
	 public Long getId() {
		 return id;
	 }
	 
	 public String getFirstName() {
		 return firstName;
	 }
	 
	 public String getLastName() {
		 return lastName;
	 }
	 
	 public String getEmail() {
		 return email;
	 }
	 
	 public String getPhoneNumber() {
		 return phoneNumber;
	 }
	 
	 public String getAddress() {
		 return address;
	 }
	 
	 public String getDateOfBirth() {
		 return dateOfBirth;
	 }
	 
	 
	 public void setId(Long newId) {
		 id = newId;
	 }
	 
	 public void setFirstName(String newFirstName) {
		 firstName = newFirstName;
	 }
	 
	 public void setLastName(String newLastName) {
		 lastName = newLastName;
	 }
	 
	 public void setEmail(String newEmail) {
		 email = newEmail;
	 }
	 
	 public void setPhoneNumber(String newPhoneNumber) {
		 phoneNumber = newPhoneNumber;
	 }
	 
	 public void setAddress(String newAddress) {
		 address = newAddress;
	 }
	 
	 public void setDateOfBirth(String newDateOfBirth) {
		 dateOfBirth = newDateOfBirth;
	 }
}
