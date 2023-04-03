package com.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.dto.AdminDto;
import com.foodbox.model.Admin;
import com.foodbox.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add-admin")
	public String addAdmin(@RequestBody AdminDto dto) {
		return adminService.addAdmin(dto);
	}
	
	@GetMapping("/getAll")
	public List<Admin> getAlladmin() {
		return adminService.getAllAdmin();
	}
}
