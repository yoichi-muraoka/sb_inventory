package com.example.inventory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.inventory.domain.Placement;

@Mapper
public interface PlacementMapper {

	List<Placement> selectByItemId(int itemId);

	Long countDistinctByItemId();

	Long countByRoomId(String roomId);

	void deleteByItemId(int itemId);

	void insert(Placement placement);

	void insertOrUpdate(List<Placement> placementList);

	void deleteZero();

}
