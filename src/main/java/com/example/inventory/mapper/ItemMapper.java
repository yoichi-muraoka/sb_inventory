package com.example.inventory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.inventory.domain.Item;

@Mapper
public interface ItemMapper {

	List<Item> selectAll();

	Item selectById(int id);

	List<Item> selectByRoomId(String roomId);

	List<Item> selectLimited(@Param("offset") int offset, @Param("num") int num);

	List<Item> selectLimitedByRoomId(@Param("roomId") String roomId, @Param("offset") int offset, @Param("num") int num);

}
