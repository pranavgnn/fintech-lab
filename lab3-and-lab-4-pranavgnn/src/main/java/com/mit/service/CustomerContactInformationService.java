package com.mit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mit.entity.CustomerContactInformation;
import com.mit.repository.CustomerContactInformationRepository;

@Service
public class CustomerContactInformationService {
    @Autowired
    private CustomerContactInformationRepository customerContactInformationRepository;

    public List<CustomerContactInformation> getAllCustomerContactInformations() {
        return customerContactInformationRepository.findAll();
    }

    public CustomerContactInformation saveCustomerContactInformation(CustomerContactInformation customerContactInformation) {
        return customerContactInformationRepository.save(customerContactInformation);
    }
}