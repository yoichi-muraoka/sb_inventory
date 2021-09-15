package com.example.inventory.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.domain.Item;
import com.example.inventory.service.ItemService;

@RestController
public class TestController {

	@Autowired
	private ItemService itService;


	@GetMapping("/test")
	public String test() {
		System.out.println("\nページ辺りの表示件数----");
		itService.setNumPerPage(3);
		System.out.println(itService.getNumPerPage());

		System.out.println("\n全ページ数----");
		System.out.println(itService.getTotalPages());
		System.out.println(itService.getTotalPagesByRoomId("R201"));

		System.out.println("\n3ページ目のデータ----");
		for(Item item : itService.getByPage(3)) {
			System.out.println(item);
		}

		System.out.println("\n3ページ目のデータ(倉庫)----");
		for(Item item : itService.getByRoomIdAndPage("R101", 2)) {
			System.out.println(item);
		}

		return "test";
	}

}
