package com.training.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.training.entities.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long> {
	
	// get Customer based on name;
	
	@Query("{name:?0}")
	List<String> getAllCustomers(String name);
	
	@Query("{name:?0,email:?1}")
	List<String> getAllCustomersNameEmail(String name,String email);
	
	@Query("{balance : {$lt: ?0}}")  
	List<Customer> getAllCustomersBalanceLt(double balance);
	
}


