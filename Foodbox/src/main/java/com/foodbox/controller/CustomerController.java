package com.foodbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.dto.CustomerDto;
import com.foodbox.model.Customer;
import com.foodbox.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:4200/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody CustomerDto dto) {
		return customerService.addCustomer(dto);
	}
	
	@GetMapping("/getAll")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomerById(@PathVariable long id) {
		return customerService.getCustomerById(id);
	}
	
	@PutMapping("/updateCustomer")
	public String updateCustomer(@RequestBody CustomerDto dto) {
		return customerService.updateCustomer(dto);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable long id) {
		return customerService.deleteCustomerById(id);
	}
}
