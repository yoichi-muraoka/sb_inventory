package com.example.inventory.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Item {

	private Integer id;
	private String name;
	private Date purchasedAt;
	private String note;

	// テーブル連携時
	private Integer amount;
	private List<Placement> placementList;

}
