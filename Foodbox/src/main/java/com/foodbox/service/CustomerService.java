package com.foodbox.service;

import java.util.List;

import com.foodbox.dto.CustomerDto;
import com.foodbox.model.Customer;

public interface CustomerService {

	public String addCustomer(CustomerDto customerdto);
	List<Customer> getAllCustomer();
	public Customer getCustomerById(long id);
	public String updateCustomer(CustomerDto customerdto);
	public String deleteCustomerById(long id);
}
