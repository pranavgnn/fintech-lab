package com.mit.service.impl;

import com.mit.service.CustomerContactInformationService;
import com.mit.entity.CustomerContactInformation;
import com.mit.repository.CustomerContactInformationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerContactInformationServiceImpl implements CustomerContactInformationService {

	@Autowired
	private CustomerContactInformationRepository customerContactInformationRepository;

	@Override
	public List<CustomerContactInformation> getAllCustomerContactInformations() {
		return customerContactInformationRepository.findAll();
	}

	@Override
	public Optional<CustomerContactInformation> getCustomerContactInformationById(Long id) {
		return customerContactInformationRepository.findById(id);
	}

	@Override
	public CustomerContactInformation createCustomerContactInformation(
			CustomerContactInformation customerContactInformation) {
		return customerContactInformationRepository.save(customerContactInformation);
	}

	@Override
	public CustomerContactInformation updateCustomerContactInformation(Long id,
			CustomerContactInformation newCustomerContactInformation) {
		return customerContactInformationRepository.findById(id).map(customerContactInformation -> {
			customerContactInformation.setType(newCustomerContactInformation.getType());
			customerContactInformation.setValue(newCustomerContactInformation.getValue());
			return customerContactInformationRepository.save(customerContactInformation);
		}).orElseThrow(() -> new RuntimeException("Customer contact information not found with id: " + id));
	}

	@Override
	public void deleteCustomerContactInformation(Long id) {
		customerContactInformationRepository.findById(id).ifPresentOrElse(
				customerContactInformationRepository::delete,
				() -> {
					throw new RuntimeException("Customer contact information not found with id: " + id);
				});
	}
}
