package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.Room;
import com.example.inventory.mapper.RoomMapper;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomMapper roomMapper;

	@Override
	public List<Room> getAll() {
		return roomMapper.selectAll();
	}

}
