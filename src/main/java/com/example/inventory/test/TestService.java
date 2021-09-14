package com.example.inventory.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.domain.Placement;
import com.example.inventory.mapper.PlacementMapper;

@Service
public class TestService {

	@Autowired
	private PlacementMapper plMapper;

	public void testService() {
		for(Placement p : plMapper.selectByItemId(2)) {
			System.out.println(p);
		}
	}

}
