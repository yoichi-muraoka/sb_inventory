package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.Item;
import com.example.inventory.mapper.ItemMapper;
import com.example.inventory.mapper.PlacementMapper;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemMapper itemMapper;

	@Autowired
	PlacementMapper placementMapper;

	@Override
	public List<Item> getAll() {
		return itemMapper.selectAll();
	}

	@Override
	public Item getOneById(int id) {
		Item item = itemMapper.selectById(id);
		// itemに配置情報をまとめる
		item.setPlacementList(placementMapper.selectByItemId(id));
		return item;
	}

}
