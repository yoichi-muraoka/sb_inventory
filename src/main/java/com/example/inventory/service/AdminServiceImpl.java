package com.example.inventory.service;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.domain.Admin;
import com.example.inventory.mapper.AdminMapper;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper adminMapper;

	@Override
	public boolean login(String loginId, String loginPass, HttpSession session) {
		Admin admin = adminMapper.selectByLoginId(loginId);

		// ログインIDに該当する管理者がいない
		if(admin == null) {
			return false;
		}

		// パスワードが異なる
		if(!BCrypt.checkpw(loginPass, admin.getLoginPass())) {
			return false;
		}

		// ログインID・パスワードが正しい
		// ⇒ 管理者氏名をセッションに格納
		session.setAttribute("name", admin.getName());
		return true;
	}

}
