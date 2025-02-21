package com.mit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mit.entity.CustomerIdentification;

public interface CustomerIdentificationRepository extends JpaRepository<CustomerIdentification, Long> {
	
}