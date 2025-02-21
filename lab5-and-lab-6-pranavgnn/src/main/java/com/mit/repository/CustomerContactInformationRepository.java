package com.mit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mit.entity.CustomerContactInformation;

public interface CustomerContactInformationRepository extends JpaRepository<CustomerContactInformation, Long> {
	
}