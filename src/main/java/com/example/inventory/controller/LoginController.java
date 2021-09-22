package com.example.inventory.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.inventory.domain.Admin;
import com.example.inventory.service.AdminService;

@Controller
@RequestMapping("/admin")
public class LoginController {

	@Autowired
	AdminService adminService;

	@Autowired
	HttpSession session;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		return "admin/login";
	}

	@PostMapping("/login")
	public String login(
			@Valid Admin admin,
			Errors errors,
			Model model) {
		if(errors.hasErrors()) {
			// 未入力
			return "admin/login";
		}
		else if(!adminService.login(admin.getLoginId(), admin.getLoginPass(), session)) {
			// ログインID、またはパスワードが間違っている
			errors.rejectValue("loginId", "wrong_id_or_password");
			return "admin/login";
		}

		// ログイン成功
		return "redirect:/admin";
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/admin/login";
	}

}
