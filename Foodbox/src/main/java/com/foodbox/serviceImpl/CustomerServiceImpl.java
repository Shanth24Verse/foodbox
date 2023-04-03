package com.foodbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.dto.CustomerDto;
import com.foodbox.exception.ResourceNotFoundException;
import com.foodbox.model.Customer;
import com.foodbox.repository.CustomerRepository;
import com.foodbox.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public String addCustomer(CustomerDto customerdto) {
		Customer customer = new Customer();
		customer.setName(customerdto.getName());
		customer.setEmail(customerdto.getEmail());
		customer.setPassword(customerdto.getPassword());
		customer.setLocation(customerdto.getLocation());
		customer.setPhone(customerdto.getPhone());
		customerRepo.save(customer);
		return "New Customer Record Saved";
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :"+id));
	}

	@Override
	public String updateCustomer(CustomerDto customerdto) {
		Customer customerToUpdate = new Customer();
		customerToUpdate.setName(customerdto.getName());
		customerToUpdate.setEmail(customerdto.getEmail());
		customerToUpdate.setPassword(customerdto.getPassword());
		customerToUpdate.setLocation(customerdto.getLocation());
		customerToUpdate.setPhone(customerdto.getPhone());
		customerRepo.save(customerToUpdate);
		return "Customer Details Record Updated";
	}

	@Override
	public String deleteCustomerById(long id) {
		customerRepo.deleteById(id);
		return "Customer Records Deleted";
	}

}
