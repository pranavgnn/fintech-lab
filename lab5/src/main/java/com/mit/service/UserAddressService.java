package com.mit.service;

import com.mit.entity.UserAddress;
import com.mit.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAddressService {
	
	private final UserAddressRepository userAddressRepository;

	public UserAddressService(UserAddressRepository userAddressRepository) {
		this.userAddressRepository = userAddressRepository;
	}

	public List<UserAddress> getAllUserAddresses() {
		return userAddressRepository.findAll();
	}

	public Optional<UserAddress> getUserAddressById(Long id) {
		return userAddressRepository.findById(id);
	}

	public UserAddress createUserAddress(UserAddress newUserAddress) {
		return userAddressRepository.save(newUserAddress);
	}

	public UserAddress updateUserAddress(Long id, UserAddress newUserAddress) {
		return userAddressRepository.findById(id).map(userAddress -> {
			userAddress.setAddressType(newUserAddress.getAddressType());
			return userAddressRepository.save(userAddress);
		}).orElseThrow(() -> new RuntimeException("User address not found with id: " + id));
	}

	public void deleteUserAddress(Long id) {
		if (!userAddressRepository.existsById(id)) {
			throw new RuntimeException("User address not found with id: " + id);
		}
		userAddressRepository.deleteById(id);
	}
}
