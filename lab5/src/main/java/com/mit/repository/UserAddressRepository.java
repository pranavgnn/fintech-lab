package com.mit.repository;

import com.mit.entity.UserAddress;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
	
}