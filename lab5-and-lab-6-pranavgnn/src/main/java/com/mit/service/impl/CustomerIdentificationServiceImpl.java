package com.mit.service.impl;

import com.mit.service.CustomerIdentificationService;
import com.mit.entity.CustomerIdentification;
import com.mit.repository.CustomerIdentificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerIdentificationServiceImpl implements CustomerIdentificationService {

	@Autowired
	private CustomerIdentificationRepository customerIdentificationRepository;

	@Override
	public List<CustomerIdentification> getAllCustomerIdentifications() {
		return customerIdentificationRepository.findAll();
	}

	@Override
	public Optional<CustomerIdentification> getCustomerIdentificationById(Long id) {
		return customerIdentificationRepository.findById(id);
	}

	@Override
	public CustomerIdentification createCustomerIdentification(CustomerIdentification customerIdentification) {
		return customerIdentificationRepository.save(customerIdentification);
	}

	@Override
	public CustomerIdentification updateCustomerIdentification(Long id,
			CustomerIdentification newCustomerIdentification) {
		return customerIdentificationRepository.findById(id).map(customerIdentification -> {
			customerIdentification.setType(newCustomerIdentification.getType());
			customerIdentification.setItem(newCustomerIdentification.getItem());
			return customerIdentificationRepository.save(customerIdentification);
		}).orElseThrow(() -> new RuntimeException("Customer identification not found with id: " + id));
	}

	@Override
	public void deleteCustomerIdentification(Long id) {
		customerIdentificationRepository.findById(id).ifPresentOrElse(
				customerIdentificationRepository::delete,
				() -> {
					throw new RuntimeException("Customer identification not found with id: " + id);
				});
	}
}
