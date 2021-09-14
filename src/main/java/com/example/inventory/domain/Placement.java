package com.example.inventory.domain;

import lombok.Data;

@Data
public class Placement {

	private Item item;
	private Room room;
	private Integer amount;

}
