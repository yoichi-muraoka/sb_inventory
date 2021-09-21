package com.example.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.Item;
import com.example.inventory.domain.Placement;
import com.example.inventory.domain.Room;
import com.example.inventory.mapper.ItemMapper;
import com.example.inventory.mapper.PlacementMapper;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	private int numPerPage = 5;

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

		// 配置情報
		List<Placement> list = placementMapper.selectByItemId(id);

		// 備品の総数
		int amount = 0;
		for(Placement p : list) {
			amount += p.getAmount();
		}

		// itemに配置情報、備品総数をまとめる
		item.setPlacementList(list);
		item.setAmount(amount);
		return item;
	}

	@Override
	public List<Item> getByRoomId(String roomId) {
		return itemMapper.selectByRoomId(roomId);
	}

	@Override
	public List<Item> getByPage(int page) {
		return itemMapper.selectLimited(getOffset(page), numPerPage);
	}

	@Override
	public List<Item> getByRoomIdAndPage(String roomId, int page) {
		return itemMapper.selectLimitedByRoomId(roomId, getOffset(page), numPerPage);
	}

	@Override
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	@Override
	public int getNumPerPage() {
		return numPerPage;
	}

	@Override
	public int getTotalPages() {
		int totalCount = placementMapper.countDistinctByItemId().intValue();
		return (int) Math.ceil((double) totalCount / numPerPage);
	}

	@Override
	public int getTotalPagesByRoomId(String roomId) {
		int totalCount = placementMapper.countByRoomId(roomId).intValue();
		return (int) Math.ceil((double) totalCount / numPerPage);
	}

	@Override
	public void deleteById(int id) {
		itemMapper.deleteById(id);
		placementMapper.deleteByItemId(id);
	}

	@Override
	public void add(Item item) {
		// 備品の追加
		itemMapper.insert(item);

		// 配置情報の追加
		var placement = new Placement();
		placement.setItem(item);
		placement.setRoom(new Room());
		placement.getRoom().setId("R101");
		placement.setAmount(item.getAmount());
		placementMapper.insert(placement);
	}


	@Override
	public void edit(Item item) {
		// 備品情報の更新
		itemMapper.update(item);

		// 配置情報に備品IDの情報を付与
		for(Placement placement : item.getPlacementList()) {
			placement.setItem(item);
		}

		// 配置情報の更新
		placementMapper.insertOrUpdate(item.getPlacementList());
		placementMapper.deleteZero();
	}

	@Override
	public Item getOneByIdToEdit(int id) {
		Item item = itemMapper.selectById(id);

		// 配置情報
		List<Placement> list = placementMapper.selectAllRoomsByItemId(id);

		// 備品の総数
		int amount = 0;
		for(Placement p : list) {
			amount += p.getAmount();
		}

		// itemに配置情報、備品総数をまとめる
		item.setPlacementList(list);
		item.setAmount(amount);
		return item;
	}

	private int getOffset(int page) {
		return numPerPage * (page - 1);
	}

}
