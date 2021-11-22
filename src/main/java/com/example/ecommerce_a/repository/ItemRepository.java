package com.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_a.domain.Item;

@Repository
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final RowMapper<Item> ITEM_ROW_MAPPER =
			new BeanPropertyRowMapper<>(Item.class);
	
	private final String TABLE_NAME = "items";
	
	public List<Item> findAll(){
		String sql = "SELECT * FROM "
				+ TABLE_NAME + " ORDER BY price_m DESC";
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);

		return itemList;
	}
		
	
}
