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
	private ItemRepository itemRepository;

	public List<Item> showList() {
		List<Item> itemList = itemRepository.findAll();
		return itemList;
	}

	public List<Item> searchByName(String name) {
		List<Item> itemList = itemRepository.findByName(name);
		System.out.println("サービスのアイテムリスト："+itemList);
		return itemList;

	}

}
