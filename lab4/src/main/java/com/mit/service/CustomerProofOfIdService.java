package com.mit.service;

import com.mit.entity.CustomerProofOfId;
import com.mit.repository.CustomerProofOfIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerProofOfIdService {
	
	 @Autowired
	 private CustomerProofOfIdRepository customerProofOfIdRepository;

		 public List<CustomerProofOfId> getAllCustomerProofOfIds() {
		 return customerProofOfIdRepository.findAll();
	 }

	 public Optional<CustomerProofOfId> getCustomerProofOfIdById(Long id) {
		 return customerProofOfIdRepository.findById(id);
	 }
	 
	 public CustomerProofOfId createCustomerProofOfId(CustomerProofOfId customerProofOfId) {
		 return customerProofOfIdRepository.save(customerProofOfId);
	 }

	 public CustomerProofOfId updateCustomerProofOfId(Long id, CustomerProofOfId newCustomerProofOfId) {
		 return customerProofOfIdRepository.findById(id).map(customerProofOfId -> {
			 customerProofOfId.setCustomerId(newCustomerProofOfId.getCustomerId());
			 customerProofOfId.setType(newCustomerProofOfId.getType());
			 customerProofOfId.setValue(newCustomerProofOfId.getValue());
			 customerProofOfId.setEffectiveDate(newCustomerProofOfId.getEffectiveDate());
			return customerProofOfIdRepository.save(customerProofOfId);
	 }).orElseThrow(() -> new RuntimeException("Customer proof of ID not found with id: " + id));
	}

	 public void deleteCustomerProofOfId(Long id) {
		 customerProofOfIdRepository.findById(id).ifPresentOrElse(
				 customerProofOfIdRepository::delete,
				 () -> {
					 throw new RuntimeException("Customer proof of ID not found with id: " + id);
				 }
		);
	 }
}
