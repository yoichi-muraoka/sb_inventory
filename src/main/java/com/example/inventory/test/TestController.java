package com.example.inventory.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.domain.Item;
import com.example.inventory.domain.Placement;
import com.example.inventory.domain.Room;
import com.example.inventory.mapper.PlacementMapper;

@RestController
public class TestController {

	@Autowired
	private PlacementMapper mapper;

	@GetMapping("/test")
	public String test() {
		var item = new Item();
		item.setId(3);
		var r101 = new Room();
		r101.setId("R101");
		var r201 = new Room();
		r201.setId("R201");
		var r211 = new Room();
		r211.setId("R211");
		var r301 = new Room();
		r301.setId("R301");

		var p1 = new Placement();
		p1.setItem(item);
		p1.setRoom(r101);
		p1.setAmount(0);
		var p2 = new Placement();
		p2.setItem(item);
		p2.setRoom(r201);
		p2.setAmount(100);
		var p3 = new Placement();
		p3.setItem(item);
		p3.setRoom(r211);
		p3.setAmount(0);
		var p4 = new Placement();
		p4.setItem(item);
		p4.setRoom(r301);
		p4.setAmount(5);

		List<Placement> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);

		mapper.insertOrUpdate(list);
		mapper.deleteZero();

		return "test";
	}

}
