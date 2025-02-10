package com.mit.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerDetails {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String type;
	 private String fullName;
	 private String dateOfBirth;
	 private String status;
	 private String mobileNo;
	 private String emailId;
	 private String countryOrigin;
	 private LocalDateTime effectiveDate;
	 
	 public Long getId() {
		 return id;
	 }
	 
	 public String getType() {
		 return type;
	 }
	 
	 public String getFullName() {
		 return fullName;
	 }
	 
	 public String getDateOfBirth() {
		 return dateOfBirth;
	 }
	 
	 public String getStatus() {
		 return status;
	 }
	 
	 public String getMobileNo() {
		 return mobileNo;
	 }
	 
	 public String getEmailId() {
		 return emailId;
	 }
	 
	 public String getCountryOrigin() {
		 return countryOrigin;
	 }
	 
	 public LocalDateTime getEffectiveDate() {
		 return effectiveDate;
	 }
	 
	 
	 public void setId(Long newId) {
		 id = newId;
	 }
	 
	 public void setType(String newType) {
		 type = newType;
	 }
	 
	 public void setFullName(String newFullName) {
		 fullName = newFullName;
	 }
	 
	 public void setDateOfBirth(String newDateOfBirth) {
		 dateOfBirth = newDateOfBirth;
	 }
	 
	 public void setStatus(String newStatus) {
		 status = newStatus;
	 }
	 
	 public void setMobileNo(String newMobileNo) {
		 mobileNo = newMobileNo;
	 }
	 
	 public void setEmailId(String newEmailId) {
		 emailId = newEmailId;
	 }
	 
	 public void setCountryOrigin(String newCountryOrigin) {
		 countryOrigin = newCountryOrigin;
	 }
	 
	 public void setEffectiveDate(LocalDateTime newEffectiveDate) {
		 effectiveDate = newEffectiveDate;
	 }
	 
}
