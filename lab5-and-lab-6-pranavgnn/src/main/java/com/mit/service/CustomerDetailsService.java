package com.mit.service;

import com.mit.entity.CustomerDetails;

import java.util.List;
import java.util.Optional;

public interface CustomerDetailsService {

    List<CustomerDetails> getAllCustomersDetails();

    Optional<CustomerDetails> getCustomerDetailsById(Long id);

    CustomerDetails createCustomerDetails(CustomerDetails customerDetails);

    CustomerDetails updateCustomerDetails(Long id, CustomerDetails newCustomerDetails);

    void deleteCustomerDetails(Long id);
}