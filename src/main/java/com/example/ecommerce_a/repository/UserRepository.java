package com.example.ecommerce_a.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_a.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final RowMapper<User> USER_ROW_MAPPER =
			new BeanPropertyRowMapper<>(User.class);
	
	private final String TABLE_NAME = "users";
	
}
