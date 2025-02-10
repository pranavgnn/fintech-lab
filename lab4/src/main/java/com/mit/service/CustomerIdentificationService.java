package com.mit.service;

import com.mit.entity.CustomerIdentification;
import com.mit.repository.CustomerIdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerIdentificationService {
	
	 @Autowired
	 private CustomerIdentificationRepository customerIdentificationRepository;

		 public List<CustomerIdentification> getAllCustomerIdentifications() {
		 return customerIdentificationRepository.findAll();
	 }

	 public Optional<CustomerIdentification> getCustomerIdentificationById(Long id) {
		 return customerIdentificationRepository.findById(id);
	 }
	 
	 public CustomerIdentification createCustomerIdentification(CustomerIdentification customerIdentification) {
		 return customerIdentificationRepository.save(customerIdentification);
	 }

	 public CustomerIdentification updateCustomerIdentification(Long id, CustomerIdentification newCustomerIdentification) {
		 return customerIdentificationRepository.findById(id).map(customerIdentification -> {
			 customerIdentification.setCustomerId(newCustomerIdentification.getCustomerId());
			 customerIdentification.setType(newCustomerIdentification.getType());
			 customerIdentification.setItem(newCustomerIdentification.getItem());
			 customerIdentification.setEffectiveDate(newCustomerIdentification.getEffectiveDate());
			return customerIdentificationRepository.save(customerIdentification);
	 }).orElseThrow(() -> new RuntimeException("Customer identification not found with id: " + id));
	}

	 public void deleteCustomerIdentification(Long id) {
		 customerIdentificationRepository.findById(id).ifPresentOrElse(
				 customerIdentificationRepository::delete,
				 () -> {
					 throw new RuntimeException("Customer identification not found with id: " + id);
				 }
		);
	 }
}
