package com.mit.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerContactInformation {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private Long customerId;
	 private Integer type;
	 private String value;
	 private LocalDateTime effectiveDate;
	 
	 public Long getId() {
		 return id;
	 }
	 
	 public Long getCustomerId() {
		 return customerId;
	 }
	 
	 public Integer getType() {
		 return type;
	 }
	 
	 public String getValue() {
		 return value;
	 }

	 
	 public LocalDateTime getEffectiveDate() {
		 return effectiveDate;
	 }
	 
	 
	 public void setId(Long newId) {
		 id = newId;
	 }
	 
	 public void setCustomerId(Long newCustomerId) {
		 customerId = newCustomerId;
	 }
	 
	 public void setType(Integer newType) {
		 type = newType;
	 }
	 
	 public void setValue(String newValue) {
		 value = newValue;
	 }
	 
	 
	 public void setEffectiveDate(LocalDateTime newEffectiveDate) {
		 effectiveDate = newEffectiveDate;
	 }
	 
}
