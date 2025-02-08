package com.mit.repository;

import com.mit.entity.CustomerDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
	
}