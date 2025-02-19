package com.mit.service;

import com.mit.entity.AddressType;
import com.mit.repository.AddressTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressTypeService {
	
	private final AddressTypeRepository addressTypeRepository;

	public AddressTypeService(AddressTypeRepository addressTypeRepository) {
		this.addressTypeRepository = addressTypeRepository;
	}

	public List<AddressType> getAllAddressTypes() {
		return addressTypeRepository.findAll();
	}

	public Optional<AddressType> getAddressTypeById(Long id) {
		return addressTypeRepository.findById(id);
	}

	public AddressType createAddressType(AddressType newAddressType) {
		return addressTypeRepository.save(newAddressType);
	}

	public AddressType updateAddressType(Long id, AddressType newAddressType) {
		return addressTypeRepository.findById(id).map(addressType -> {
			addressType.setType(newAddressType.getType());  // Do not modify ID
			return addressTypeRepository.save(addressType);
		}).orElseThrow(() -> new RuntimeException("Address type not found with id: " + id));
	}

	public void deleteAddressType(Long id) {
		if (!addressTypeRepository.existsById(id)) {
			throw new RuntimeException("Address type not found with id: " + id);
		}
		addressTypeRepository.deleteById(id);
	}
}
