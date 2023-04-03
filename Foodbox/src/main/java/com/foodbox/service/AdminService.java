package com.foodbox.service;

import java.util.List;

import com.foodbox.dto.AdminDto;
import com.foodbox.model.Admin;

public interface AdminService {

	public String addAdmin(AdminDto admindto);
	List<Admin> getAllAdmin();
}
