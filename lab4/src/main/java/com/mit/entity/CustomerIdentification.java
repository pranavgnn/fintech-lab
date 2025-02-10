package com.mit.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerIdentification {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private Long customerId;
	 private Integer type;
	 private String item;
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
	 
	 public String getItem() {
		 return item;
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
	 
	 public void setItem(String newItem) {
		 item = newItem;
	 }
	 
	 
	 public void setEffectiveDate(LocalDateTime newEffectiveDate) {
		 effectiveDate = newEffectiveDate;
	 }
	 
}
