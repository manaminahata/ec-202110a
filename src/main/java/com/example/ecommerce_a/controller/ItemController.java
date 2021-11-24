package com.example.ecommerce_a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce_a.domain.Item;
import com.example.ecommerce_a.form.SearchItemByNameForm;
import com.example.ecommerce_a.service.ItemService;

@Controller
@RequestMapping("/shop")
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@ModelAttribute
	public SearchItemByNameForm setUpSearchItemByNameForm(){
		return new SearchItemByNameForm();
	}
	
	@RequestMapping("")
	public String showList(Model model) {
		List<Item> itemList = itemService.showList();
		model.addAttribute("itemList",itemList);
		return "item_list";
	}

	@RequestMapping("/search-item-by-name")
	public String searchItemByName(SearchItemByNameForm form,Model model) {
		System.out.println("検索ワード："+form.getSearchingName());
		List<Item> itemList = itemService.searchByName(form.getSearchingName());
		if(itemList.size() == 0) {
			itemList = itemService.showList();
			model.addAttribute("searchMessage", "該当する商品がありません");
		}

		model.addAttribute("itemList", itemList);
		return "item_list";
	}
}
