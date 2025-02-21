package com.mit.service;

import com.mit.entity.CustomerProofOfId;

import java.util.List;
import java.util.Optional;

public interface CustomerProofOfIdService {

    List<CustomerProofOfId> getAllCustomerProofOfIds();

    Optional<CustomerProofOfId> getCustomerProofOfIdById(Long id);

    CustomerProofOfId createCustomerProofOfId(CustomerProofOfId customerProofOfId);

    CustomerProofOfId updateCustomerProofOfId(Long id, CustomerProofOfId newCustomerProofOfId);

    void deleteCustomerProofOfId(Long id);
}