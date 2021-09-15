package com.example.inventory.service;

import java.util.List;

import com.example.inventory.domain.Item;

public interface ItemService {

	List<Item> getAll();

	Item getOneById(int id);

	List<Item> getByRoomId(String roomId);

}
