package com.mit.service.impl;

import com.mit.service.CustomerProofOfIdService;
import com.mit.entity.CustomerProofOfId;
import com.mit.repository.CustomerProofOfIdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerProofOfIdServiceImpl implements CustomerProofOfIdService {

    @Autowired
    private CustomerProofOfIdRepository customerProofOfIdRepository;

    @Override
    public List<CustomerProofOfId> getAllCustomerProofOfIds() {
        return customerProofOfIdRepository.findAll();
    }

    @Override
    public Optional<CustomerProofOfId> getCustomerProofOfIdById(Long id) {
        return customerProofOfIdRepository.findById(id);
    }

    @Override
    public CustomerProofOfId createCustomerProofOfId(CustomerProofOfId customerProofOfId) {
        return customerProofOfIdRepository.save(customerProofOfId);
    }

    @Override
    public CustomerProofOfId updateCustomerProofOfId(Long id, CustomerProofOfId newCustomerProofOfId) {
        return customerProofOfIdRepository.findById(id).map(customerProofOfId -> {
            customerProofOfId.setType(newCustomerProofOfId.getType());
            customerProofOfId.setValue(newCustomerProofOfId.getValue());
            customerProofOfId.setStartDate(newCustomerProofOfId.getStartDate());
            customerProofOfId.setEndDate(newCustomerProofOfId.getEndDate());
            return customerProofOfIdRepository.save(customerProofOfId);
        }).orElseThrow(() -> new RuntimeException("Customer proof of ID not found with id: " + id));
    }

    @Override
    public void deleteCustomerProofOfId(Long id) {
        customerProofOfIdRepository.findById(id).ifPresentOrElse(
                customerProofOfIdRepository::delete,
                () -> {
                    throw new RuntimeException("Customer proof of ID not found with id: " + id);
                });
    }
}
