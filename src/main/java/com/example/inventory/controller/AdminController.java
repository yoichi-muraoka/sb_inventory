package com.example.inventory.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.inventory.domain.Item;
import com.example.inventory.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ItemService itemService;

	@InitBinder
	public void initBinderForm(WebDataBinder binder) {
		var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class,  new CustomDateEditor(dateFormat, true));
	}


	@GetMapping
	public String index(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) {
		model.addAttribute("itemList", itemService.getByPage(page));
		model.addAttribute("page", page);
		model.addAttribute("totalPages", itemService.getTotalPages());
		return ("admin/index");
	}

	@GetMapping("/delete")
	public String delete(
			@RequestParam(name = "id", required = false) Integer id) {
		if(id != null) {
			itemService.deleteById(id);
		}
		return "redirect:/admin";
	}

	@GetMapping("/add")
	public String add(Model model) {
		Item item = new Item();
		// 初期値の設定
		item.setAmount(0);
		item.setPurchasedAt(new Date());
		model.addAttribute("item", item);
		return "admin/add";
	}

	@PostMapping("/add")
	public String add(
			@Valid Item item,
			Errors errors,
			Model model) {
		if(errors.hasErrors()) {
			return "admin/add";
		}

		itemService.add(item);
		return "redirect:/admin";
	}

	@GetMapping("/edit")
	public String edit(
			@RequestParam(name = "id", required = false) Integer id,
			Model model) {
		Item item = null;
		if(id != null) {
			item = itemService.getOneByIdToEdit(id);
		}

		if(item == null) {
			return "redirect:/admin";
		}

		model.addAttribute("item", item);
		return "admin/edit";
	}

}
