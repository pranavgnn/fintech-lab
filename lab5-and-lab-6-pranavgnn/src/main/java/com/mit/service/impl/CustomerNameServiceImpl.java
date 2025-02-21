package com.mit.service.impl;

import com.mit.service.CustomerNameService;
import com.mit.entity.CustomerName;
import com.mit.repository.CustomerNameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerNameServiceImpl implements CustomerNameService {

    @Autowired
    private CustomerNameRepository customerNameRepository;

    @Override
    public List<CustomerName> getAllCustomerNames() {
        return customerNameRepository.findAll();
    }

    @Override
    public Optional<CustomerName> getCustomerNameById(Long id) {
        return customerNameRepository.findById(id);
    }

    @Override
    public CustomerName createCustomerName(CustomerName customerName) {
        return customerNameRepository.save(customerName);
    }

    @Override
    public CustomerName updateCustomerName(Long id, CustomerName newCustomerName) {
        return customerNameRepository.findById(id).map(customerName -> {
            customerName.setFirstName(newCustomerName.getFirstName());
            customerName.setMiddleName(newCustomerName.getMiddleName());
            customerName.setLastName(newCustomerName.getLastName());
            return customerNameRepository.save(customerName);
        }).orElseThrow(() -> new RuntimeException("Customer name not found with id: " + id));
    }

    @Override
    public void deleteCustomerName(Long id) {
        customerNameRepository.findById(id).ifPresentOrElse(
                customerNameRepository::delete,
                () -> {
                    throw new RuntimeException("Customer name not found with id: " + id);
                });
    }
}
