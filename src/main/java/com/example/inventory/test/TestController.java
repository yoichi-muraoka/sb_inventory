package com.example.inventory.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.domain.Item;
import com.example.inventory.mapper.ItemMapper;
import com.example.inventory.mapper.PlacementMapper;

@RestController
public class TestController {

	@Autowired
	private ItemMapper itMapper;

	@Autowired
	private PlacementMapper plMapper;

	@GetMapping("/test")
	public String test() {
		for(Item item : itMapper.selectLimited(2, 3)) {
			System.out.println(item);
		}

		System.out.println("\n---------\n");

		for(Item item : itMapper.selectLimitedByRoomId("R211", 1, 3)) {
			System.out.println(item);
		}

		System.out.println("\n---------\n");

		System.out.println(plMapper.countDistinctByItemId());
		System.out.println(plMapper.countByRoomId("R211"));

		return "test";
	}

}
