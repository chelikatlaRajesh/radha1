package com.training;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.entities.Book;
import com.training.repo.BookRepo;
import com.training.repo.CustomerRepo;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@OpenAPIDefinition(info = @Info(title = "Books API", version = "2.0", description = "Books Information"))
@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootBookProducerProjectDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookProducerProjectDbApplication.class, args);
	}

	@Autowired
	private BookRepo bookRepo;
	
	@PostConstruct
	public void init()
	{
		
		
		/*
		 * bookRepo.save(new Book("1234", "C", 150.20, 100)); bookRepo.save(new
		 * Book("4567", "CPlus", 175.20, 100));
		 */
		 
		 
		
		/*
		 * Optional<Book> bookOp = bookRepo.findById("1234"); if(bookOp.isPresent())
		 * System.out.println(bookOp.get());
		 * 
		 * //update book stock based on id.
		 * 
		 * Optional<Book> bookOp1 = bookRepo.findById("1234"); if(bookOp1.isPresent()) {
		 * Book bookUp = bookOp1.get(); bookUp.setStock(bookUp.getStock()+50);
		 * bookRepo.save(bookUp); }
		 * 
		 * //delete Optional<Book> bookOp2 = bookRepo.findById("4567");
		 * if(bookOp2.isPresent()) { Book bookUp = bookOp2.get();
		 * bookRepo.delete(bookUp); }
		 */
	}
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			/*
			 * System.out.println("Here is the runner...");
			 * 
			 * System.out.print(bookRepo.findByTitle("CSharp"));
			 * System.out.println(bookRepo.findByStockGreaterThan(100));
			 * 
			 * System.out.println(bookRepo.findByTitleLike("C%"));
			 */
		
	//	System.out.println(bookRepo.getAllBooksPriceGt(200));
		//	System.out.println("no of records updated:"+bookRepo.updateBookStock(120, 50));
		
		
			System.out.println(customerRepo.getAllCustomers("sam"));
			System.out.println(customerRepo.getAllCustomersNameEmail("sam","sam@gmail.com"));
		System.out.println(customerRepo.getAllCustomersBalanceLt(3000));
		};
	}
}
