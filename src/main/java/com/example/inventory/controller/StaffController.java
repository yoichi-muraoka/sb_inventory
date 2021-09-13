package com.example.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.inventory.service.ItemService;

@Controller
public class StaffController {

	@Autowired
	private ItemService itemService;

	// 備品リスト
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("itemList", itemService.getAll());
		return "index";
	}


	// 備品個別表示
	@GetMapping("/show")
	public String show() {
		return "show";
	}

}
