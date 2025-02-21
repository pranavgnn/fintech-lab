package com.mit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mit.entity.CustomerDetails;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {
	
}