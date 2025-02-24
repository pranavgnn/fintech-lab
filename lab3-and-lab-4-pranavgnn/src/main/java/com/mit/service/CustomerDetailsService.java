package com.mit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mit.entity.CustomerDetails;
import com.mit.repository.CustomerDetailsRepository;

@Service
public class CustomerDetailsService {
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    public List<CustomerDetails> getAllCustomerDetails() {
        return customerDetailsRepository.findAll();
    }

    public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails) {
        return customerDetailsRepository.save(customerDetails);
    }
}