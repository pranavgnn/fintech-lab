package com.mit.service.impl;

import com.mit.service.CustomerDetailsService;
import com.mit.entity.CustomerDetails;
import com.mit.repository.CustomerDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;

	@Override
	public List<CustomerDetails> getAllCustomersDetails() {
		return customerDetailsRepository.findAll();
	}

	@Override
	public Optional<CustomerDetails> getCustomerDetailsById(Long id) {
		return customerDetailsRepository.findById(id);
	}

	@Override
	public CustomerDetails createCustomerDetails(CustomerDetails customerDetails) {
		return customerDetailsRepository.save(customerDetails);
	}

	@Override
	public CustomerDetails updateCustomerDetails(Long id, CustomerDetails newCustomerDetails) {
		return customerDetailsRepository.findById(id).map(customerDetails -> {
			customerDetails.setCustomerName(newCustomerDetails.getCustomerName());
			customerDetails.setDateOfBirth(newCustomerDetails.getDateOfBirth());
			customerDetails.setCustomerContactInformations(newCustomerDetails.getCustomerContactInformations());
			customerDetails.setCustomerIdentifications(newCustomerDetails.getCustomerIdentifications());
			customerDetails.setCustomerProofOfIds(newCustomerDetails.getCustomerProofOfIds());
			return customerDetailsRepository.save(customerDetails);
		}).orElseThrow(() -> new RuntimeException("Customer details not found with id: " + id));
	}

	@Override
	public void deleteCustomerDetails(Long id) {
		customerDetailsRepository.findById(id).ifPresentOrElse(
				customerDetailsRepository::delete,
				() -> {
					throw new RuntimeException("Customer details not found with id: " + id);
				});
	}
}
