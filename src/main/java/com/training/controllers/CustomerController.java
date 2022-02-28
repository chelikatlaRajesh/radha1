package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.entities.Customer;
import com.training.repo.CustomerRepo;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;
	
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		customerRepo.save(customer);
		return customer;
	}
	
	@GetMapping("/getallcustomers")
	public List<Customer> getAllCustomers()
	{
		return customerRepo.findAll();
	}
}

