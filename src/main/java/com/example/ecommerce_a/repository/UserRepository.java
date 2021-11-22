package com.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_a.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final RowMapper<User> USER_ROW_MAPPER =
			new BeanPropertyRowMapper<>(User.class);
	
	private final String TABLE_NAME = "users";
	
	/**
	 * ログイン時にメールアドレスとパスワードが一致しているか確認するためのメソッド
	 * @param email
	 * @param password
	 * @return　メールアドレスとパスワードが一致した施設を取得する
	 */
	public User findByEmailAndPassword(User user) {
		String sql = "SELECT * FROM users WHERE email=:email AND password=:password";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
	
}
