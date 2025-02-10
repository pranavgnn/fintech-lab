package com.mit.repository;

import com.mit.entity.CustomerIdentification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerIdentificationRepository extends JpaRepository<CustomerIdentification, Long> {
	
}