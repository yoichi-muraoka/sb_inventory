package com.example.inventory.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.domain.Placement;
import com.example.inventory.mapper.PlacementMapper;

@RestController
public class TestController {

	@Autowired
	private PlacementMapper plMapper;

	@Autowired
	private TestService testService;

	@GetMapping("/test")
	public String test() {

		for(Placement p : plMapper.selectByItemId(2)) {
			System.out.println(p);
		}

		System.out.println("\n--------------\n");

		testService.testService();

		return "test";
	}

}
