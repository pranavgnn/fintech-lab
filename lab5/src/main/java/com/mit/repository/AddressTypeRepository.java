package com.mit.repository;

import com.mit.entity.AddressType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
	
}