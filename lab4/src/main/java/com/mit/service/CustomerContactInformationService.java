package com.mit.service;

import com.mit.entity.CustomerContactInformation;
import com.mit.repository.CustomerContactInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerContactInformationService {
	
	 @Autowired
	 private CustomerContactInformationRepository customerContactInformationRepository;

		 public List<CustomerContactInformation> getAllCustomerContactInformations() {
		 return customerContactInformationRepository.findAll();
	 }

	 public Optional<CustomerContactInformation> getCustomerContactInformationById(Long id) {
		 return customerContactInformationRepository.findById(id);
	 }
	 
	 public CustomerContactInformation createCustomerContactInformation(CustomerContactInformation customerContactInformation) {
		 return customerContactInformationRepository.save(customerContactInformation);
	 }

	 public CustomerContactInformation updateCustomerContactInformation(Long id, CustomerContactInformation newCustomerContactInformation) {
		 return customerContactInformationRepository.findById(id).map(customerContactInformation -> {
			 customerContactInformation.setCustomerId(newCustomerContactInformation.getCustomerId());
			 customerContactInformation.setType(newCustomerContactInformation.getType());
			 customerContactInformation.setValue(newCustomerContactInformation.getValue());
			 customerContactInformation.setEffectiveDate(newCustomerContactInformation.getEffectiveDate());
			return customerContactInformationRepository.save(customerContactInformation);
	 }).orElseThrow(() -> new RuntimeException("Customer contact information not found with id: " + id));
	}

	 public void deleteCustomerContactInformation(Long id) {
		 customerContactInformationRepository.findById(id).ifPresentOrElse(
				 customerContactInformationRepository::delete,
				 () -> {
					 throw new RuntimeException("Customer contact information not found with id: " + id);
				 }
		);
	 }
}
