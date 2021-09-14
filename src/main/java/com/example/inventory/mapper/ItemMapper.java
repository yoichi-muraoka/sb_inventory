package com.example.inventory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.inventory.domain.Item;

@Mapper
public interface ItemMapper {

	List<Item> selectAll();

	Item selectById(int id);

}
