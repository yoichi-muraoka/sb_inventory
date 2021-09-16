package com.example.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.inventory.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ItemService itemService;

	@GetMapping
	public String index(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) {
		model.addAttribute("itemList", itemService.getByPage(page));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", itemService.getTotalPages());
		return ("admin/index");
	}

	@GetMapping("/delete")
	public String delete(
			@RequestParam(name = "id", required = false) Integer id) {
		if(id != null) {
			itemService.deleteById(id);
		}
		return "redirect:/admin";
	}

}
