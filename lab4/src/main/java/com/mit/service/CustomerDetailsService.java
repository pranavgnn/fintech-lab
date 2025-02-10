package com.mit.service;

import com.mit.entity.CustomerDetails;
import com.mit.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsService {
	
	 @Autowired
	 private CustomerDetailsRepository customerDetailsRepository;

		 public List<CustomerDetails> getAllCustomersDetails() {
		 return customerDetailsRepository.findAll();
	 }

	 public Optional<CustomerDetails> getCustomerDetailsById(Long id) {
		 return customerDetailsRepository.findById(id);
	 }
	 
	 public CustomerDetails createCustomerDetails(CustomerDetails customerDetails) {
		 return customerDetailsRepository.save(customerDetails);
	 }

	 public CustomerDetails updateCustomerDetails(Long id, CustomerDetails newCustomerDetails) {
		 return customerDetailsRepository.findById(id).map(customerDetails -> {
			customerDetails.setType(newCustomerDetails.getType());
			customerDetails.setFullName(newCustomerDetails.getFullName());
			customerDetails.setDateOfBirth(newCustomerDetails.getDateOfBirth());
			customerDetails.setStatus(newCustomerDetails.getStatus());
			customerDetails.setMobileNo(newCustomerDetails.getMobileNo());
			customerDetails.setEmailId(newCustomerDetails.getEmailId());
			customerDetails.setEffectiveDate(newCustomerDetails.getEffectiveDate());
			customerDetails.setCountryOrigin(newCustomerDetails.getCountryOrigin());
			return customerDetailsRepository.save(customerDetails);
	 }).orElseThrow(() -> new RuntimeException("Customer details not found with id: " + id));
	}

	 public void deleteCustomerDetails(Long id) {
		 customerDetailsRepository.findById(id).ifPresentOrElse(
				 customerDetailsRepository::delete,
				 () -> {
					 throw new RuntimeException("Customer details not found with id: " + id);
				 }
		);
	 }
}
