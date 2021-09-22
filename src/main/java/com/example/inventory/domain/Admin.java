package com.example.inventory.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Admin {

	@NotBlank
	private String loginId;

	@NotBlank
	private String loginPass;

	private String name;

}
