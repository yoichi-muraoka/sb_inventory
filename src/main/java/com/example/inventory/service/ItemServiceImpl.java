package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.Item;
import com.example.inventory.mapper.ItemMapper;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemMapper itemMapper;

	@Override
	public List<Item> getAll() {
		return itemMapper.selectAll();
	}

}
