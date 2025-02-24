package com.mit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mit.entity.CustomerIdentification;
import com.mit.repository.CustomerIdentificationRepository;

@Service
public class CustomerIdentificationService {
    @Autowired
    private CustomerIdentificationRepository customerIdentificationRepository;

    public List<CustomerIdentification> getAllCustomerIdentifications() {
        return customerIdentificationRepository.findAll();
    }

    public CustomerIdentification saveCustomerIdentification(CustomerIdentification customerIdentification) {
        return customerIdentificationRepository.save(customerIdentification);
    }
}