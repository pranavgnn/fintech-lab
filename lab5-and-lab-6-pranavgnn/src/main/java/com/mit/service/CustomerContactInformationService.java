package com.mit.service;

import com.mit.entity.CustomerContactInformation;

import java.util.List;
import java.util.Optional;

public interface CustomerContactInformationService {

    List<CustomerContactInformation> getAllCustomerContactInformations();

    Optional<CustomerContactInformation> getCustomerContactInformationById(Long id);

    CustomerContactInformation createCustomerContactInformation(CustomerContactInformation customerContactInformation);

    CustomerContactInformation updateCustomerContactInformation(Long id, CustomerContactInformation newCustomerContactInformation);

    void deleteCustomerContactInformation(Long id);
}