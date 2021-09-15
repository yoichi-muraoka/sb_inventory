package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.inventory.domain.Item;
import com.example.inventory.service.ItemService;
import com.example.inventory.service.RoomService;

@Controller
public class StaffController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private RoomService roomService;

	// 備品リスト
	@GetMapping("/")
	public String index(
			@RequestParam(name = "roomId", defaultValue = "") String roomId,
			Model model) {
		List<Item> itemList;
		if(!roomId.isBlank()) {
			itemList = itemService.getByRoomId(roomId);
		}
		else {
			itemList = itemService.getAll();
		}

		model.addAttribute("itemList", itemList);
		model.addAttribute("roomList", roomService.getAll());
		model.addAttribute("roomId", roomId);
		return "index";
	}


	// 備品個別表示
	@GetMapping("/show")
	public String show(
			@RequestParam(name = "id", required = false) Integer id,
			Model model) {
		Item item = null;
		if(id != null) {
			item = itemService.getOneById(id);
		}

		if(item == null) {
			return "redirect:/";
		}

		model.addAttribute("item", item);
		return "show";
	}

}
