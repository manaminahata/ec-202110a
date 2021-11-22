package com.example.ecommerce_a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce_a.domain.User;
import com.example.ecommerce_a.repository.UserRepository;

@Transactional
@Service
public class SignUpService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> checkEmail(String email) {
		return userRepository.findByMailAddress(email);
	}
	
	public void signUp(User user) {
		userRepository.insert(user);
	}
	
	
	
}
