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
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) {
		List<Item> itemList;
		int totalPages = 0;
		if(!roomId.isBlank()) {
			itemList = itemService.getByRoomIdAndPage(roomId, page);
			totalPages = itemService.getTotalPagesByRoomId(roomId);
		}
		else {
			itemList = itemService.getByPage(page);
			totalPages = itemService.getTotalPages();
		}

		model.addAttribute("itemList", itemList);
		model.addAttribute("roomList", roomService.getAll());
		model.addAttribute("roomId", roomId);
		model.addAttribute("page", page);
		model.addAttribute("totalPages", totalPages);
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
