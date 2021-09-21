package com.example.inventory.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Item {

	private Integer id;

	@NotBlank
	@Size(max = 30)
	private String name;

	private Date purchasedAt;

	@Size(max = 255)
	private String note;

	// テーブル連携時
	@Min(0)
	private Integer amount;
	private List<Placement> placementList;

}
