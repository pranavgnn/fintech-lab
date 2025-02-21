package com.mit.service;

import com.mit.entity.CustomerIdentification;

import java.util.List;
import java.util.Optional;

public interface CustomerIdentificationService {

    List<CustomerIdentification> getAllCustomerIdentifications();

    Optional<CustomerIdentification> getCustomerIdentificationById(Long id);

    CustomerIdentification createCustomerIdentification(CustomerIdentification customerIdentification);

    CustomerIdentification updateCustomerIdentification(Long id, CustomerIdentification newCustomerIdentification);

    void deleteCustomerIdentification(Long id);
}