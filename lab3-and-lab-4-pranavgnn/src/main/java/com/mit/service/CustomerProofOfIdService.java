package com.mit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mit.entity.CustomerProofOfId;
import com.mit.repository.CustomerProofOfIdRepository;

@Service
public class CustomerProofOfIdService {
    @Autowired
    private CustomerProofOfIdRepository customerProofOfIdRepository;

    public List<CustomerProofOfId> getAllCustomerProofOfIds() {
        return customerProofOfIdRepository.findAll();
    }

    public CustomerProofOfId saveCustomerProofOfId(CustomerProofOfId customerProofOfId) {
        return customerProofOfIdRepository.save(customerProofOfId);
    }
}