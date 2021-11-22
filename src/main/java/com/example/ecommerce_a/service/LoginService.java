package com.example.ecommerce_a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_a.domain.User;
import com.example.ecommerce_a.repository.UserRepository;

@Service
public class LoginService {
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * メールアドレスとパスワードで検索するメソッド。
	 * @param user
	 * @return　
	 */
	public User login(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return user;
	}
}
