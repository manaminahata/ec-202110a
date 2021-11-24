package com.example.ecommerce_a.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_a.domain.Item;

@Repository
public class ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private final RowMapper<Item> ITEM_ROW_MAPPER = new BeanPropertyRowMapper<>(Item.class);

	private final String TABLE_NAME = "items";

	public List<Item> findAll() {
		String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY price_m DESC";
		List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
		return itemList;
	}

	public List<Item> findByName(String name) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name like :name ORDER BY price_m DESC";
		// SELECT * FROM items WHERE name like '%パーカー%' ORDER BY price_m DESC;
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name","%"+name+"%");
		
		List<Item> itemList = template.query(sql, param, ITEM_ROW_MAPPER);
		
		System.out.println("リポジトリのアイテムリスト："+itemList);

		return itemList;
	}

}
