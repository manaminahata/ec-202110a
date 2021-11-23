package com.example.ecommerce_a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.domain.Item;
import com.example.ecommerce_a.service.ItemService;

@Controller
@RequestMapping("")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	
	
	@RequestMapping("/item_list_pizza.html")
	public String showList(Model model) {
		List<Item> itemList = itemService.showList();
		model.addAttribute("itemList",itemList);
		return "item_list";
	}

}
