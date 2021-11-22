package com.example.ecommerce_a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce_a.domain.Item;
import com.example.ecommerce_a.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	@Autowired
	private ItemRepository repository;
	
	public List<Item> showList(){
		List<Item> itemList = repository.findAll();
		return itemList;
	}
	
}
