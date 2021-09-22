package com.example.inventory.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.inventory.domain.Admin;

@Mapper
public interface AdminMapper {

	Admin selectByLoginId(String loginId);

}
