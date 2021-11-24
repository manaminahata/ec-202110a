package com.example.ecommerce_a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.domain.Item;
import com.example.ecommerce_a.service.ItemService;

@Controller
@RequestMapping("/shop")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	
	
	@RequestMapping("")
	public String showList(Model model) {
		List<Item> itemList = itemService.showList();
		System.out.println(itemList);
		model.addAttribute("itemList",itemList);
		return "item_list";
	}

}
