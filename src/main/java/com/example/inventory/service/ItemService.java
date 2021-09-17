package com.example.inventory.service;

import java.util.List;

import com.example.inventory.domain.Item;

public interface ItemService {

	List<Item> getAll();

	Item getOneById(int id);

	List<Item> getByRoomId(String roomId);

	List<Item> getByPage(int page);

	List<Item> getByRoomIdAndPage(String roomId, int page);

	void setNumPerPage(int numPerPage);

	int getNumPerPage();

	int getTotalPages();

	int getTotalPagesByRoomId(String roomId);

	void deleteById(int id);

	void add(Item item);

}
