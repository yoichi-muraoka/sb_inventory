package com.example.inventory.service;

import javax.servlet.http.HttpSession;

public interface AdminService {

	boolean login(String loginId, String loginPass, HttpSession session);

}
