package com.example.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {

	// 備品リスト
	@GetMapping("/")
	public String index() {
		return "index";
	}


	// 備品個別表示
	@GetMapping("/show")
	public String show() {
		return "show";
	}

}
