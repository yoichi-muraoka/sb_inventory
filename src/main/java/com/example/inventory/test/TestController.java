package com.example.inventory.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.domain.Placement;
import com.example.inventory.mapper.PlacementMapper;

@RestController
public class TestController {

	@Autowired
	private PlacementMapper mapper;

	@GetMapping("/test")
	public List<Placement> test() {
		return mapper.selectAllByItemId(1);
	}

}
