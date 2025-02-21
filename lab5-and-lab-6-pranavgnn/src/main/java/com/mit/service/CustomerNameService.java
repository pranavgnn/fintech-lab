package com.mit.service;

import com.mit.entity.CustomerName;

import java.util.List;
import java.util.Optional;

public interface CustomerNameService {

    List<CustomerName> getAllCustomerNames();

    Optional<CustomerName> getCustomerNameById(Long id);

    CustomerName createCustomerName(CustomerName customerName);

    CustomerName updateCustomerName(Long id, CustomerName newCustomerName);

    void deleteCustomerName(Long id);
}