package com.foodbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.dto.AdminDto;
import com.foodbox.model.Admin;
import com.foodbox.repository.AdminRepository;
import com.foodbox.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public String addAdmin(AdminDto admindto) {
		Admin admin = new Admin();
		admin.setEmail(admindto.getEmail());
		admin.setPassword(admindto.getPassword());
		adminRepo.save(admin);
		return "New Admin Record Saved";
	}

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepo.findAll();
	}

}
