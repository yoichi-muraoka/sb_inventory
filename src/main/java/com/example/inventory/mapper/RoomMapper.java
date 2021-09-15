package com.example.inventory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.inventory.domain.Room;

@Mapper
public interface RoomMapper {

	List<Room> selectAll();

}
