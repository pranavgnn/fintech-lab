package com.mit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mit.entity.CustomerDetails;
import com.mit.service.CustomerDetailsService;

@RestController
@RequestMapping("/api/customer-details")
public class CustomerDetailsController {
    @Autowired
    private CustomerDetailsService customerDetailsService;

    @GetMapping
    public List<CustomerDetails> getAllCustomerDetails() {
        return customerDetailsService.getAllCustomerDetails();
    }

    @PostMapping
    public CustomerDetails createUser(@RequestBody CustomerDetails customerDetails) {
        return customerDetailsService.saveCustomerDetails(customerDetails);
    }
}
