package com.example.inventory.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.domain.Item;
import com.example.inventory.mapper.ItemMapper;

@RestController
public class TestController {

	@Autowired
	private ItemMapper mapper;

	@GetMapping("/test")
	public List<Item> testItemList() {
		return mapper.selectAll();
	}

}
