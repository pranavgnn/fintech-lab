package com.mit.service;

import com.mit.entity.User;
import com.mit.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public List<User> getSortedUsers(String order) {
		if (!(order.equals("asc") || order.equals("desc")))
			return getAllUsers();
		
		Direction dir = order.equals("asc") ? Direction.ASC : Direction.DESC;
		return userRepository.findAll(Sort.by(dir, "name"));
	}
	
	public List<User> getPagedAndSortedUsers(String pageStr, String order) {
		int pageNumber = Integer.parseInt(pageStr);
		
//		List<User> users = getSortedUsers(order);
		
		Pageable paging = PageRequest.of(pageNumber, 2, Sort.unsorted());
	    Page<User> page = userRepository.findAll(paging);
	    
	    return page.getContent();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}

	public User updateUser(Long id, User newUser) {
		return userRepository.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setGender(newUser.getGender());
			user.setUserAddresses(newUser.getUserAddresses());
			return userRepository.save(user);
		}).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
	}

	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("User not found with id: " + id);
		}
		userRepository.deleteById(id);
	}
}
