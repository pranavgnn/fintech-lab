package com.mit.repository;

import com.mit.entity.CustomerProofOfId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerProofOfIdRepository extends JpaRepository<CustomerProofOfId, Long> {
	
}