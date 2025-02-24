package com.mit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mit.entity.CustomerProofOfId;
import com.mit.service.CustomerProofOfIdService;

@RestController
@RequestMapping("/api/customer-proof-of-id")
public class CustomerProofOfIdController {
    @Autowired
    private CustomerProofOfIdService customerProofOfIdService;

    @GetMapping
    public List<CustomerProofOfId> getAllCustomerProofOfIds() {
        return customerProofOfIdService.getAllCustomerProofOfIds();
    }

    @PostMapping
    public CustomerProofOfId createCustomerProofOfId(@RequestBody CustomerProofOfId customerProofOfId) {
        return customerProofOfIdService.saveCustomerProofOfId(customerProofOfId);
    }
}
