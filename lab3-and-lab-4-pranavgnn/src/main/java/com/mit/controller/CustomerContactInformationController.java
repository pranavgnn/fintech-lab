package com.mit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mit.entity.CustomerContactInformation;
import com.mit.service.CustomerContactInformationService;

@RestController
@RequestMapping("/api/customer-contact-information")
public class CustomerContactInformationController {
    @Autowired
    private CustomerContactInformationService customerContactInformationService;

    @GetMapping
    public List<CustomerContactInformation> getAllContactInformations() {
        return customerContactInformationService.getAllCustomerContactInformations();
    }

    @PostMapping
    public CustomerContactInformation createCustomerContactInformation(@RequestBody CustomerContactInformation customerContactInformation) {
        return customerContactInformationService.saveCustomerContactInformation(customerContactInformation);
    }
}
