package com.mit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mit.entity.CustomerIdentification;
import com.mit.service.CustomerIdentificationService;

@RestController
@RequestMapping("/api/customer-identification")
public class CustomerIdentificationController {
    @Autowired
    private CustomerIdentificationService customerIdentificationService;

    @GetMapping
    public List<CustomerIdentification> getAllCustomerIdentifications() {
        return customerIdentificationService.getAllCustomerIdentifications();
    }

    @PostMapping
    public CustomerIdentification createCustomerIdentification(@RequestBody CustomerIdentification customerIdentification) {
        return customerIdentificationService.saveCustomerIdentification(customerIdentification);
    }
}
