package com.mit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mit.entity.CustomerName;

public interface CustomerNameRepository extends JpaRepository<CustomerName, Long> {
	
}