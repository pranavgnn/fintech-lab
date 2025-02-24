package com.mit.repository;

import com.mit.entity.CustomerContactInformation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContactInformationRepository extends JpaRepository<CustomerContactInformation, Long> {
	
}