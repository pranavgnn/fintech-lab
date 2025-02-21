package com.mit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mit.entity.CustomerProofOfId;

public interface CustomerProofOfIdRepository extends JpaRepository<CustomerProofOfId, Long> {
	
}