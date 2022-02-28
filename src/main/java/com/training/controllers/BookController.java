package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entities.Book;
import com.training.services.interfaces.BookServiceInterface;



//@EnableSwagger2
@RestController
@RequestMapping("bookstore")
public class BookController {
	
	@Autowired
	private BookServiceInterface bookService;
	
	@Value("${server.port}")
	private int port;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "This is a Rest Controller";
	}
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return bookService.getAllBooks();
	}
	
	@GetMapping("/book/isbn/{isbn}")            //localhost:8082/bookstore/book/isbn/1234
	public Book getBook(@PathVariable("isbn") String isbn)
	{
		Book bookFetched = bookService.getBook(isbn);
		bookFetched.setPort(port);
		return bookFetched;
	}
	
	@PostMapping("/addbook")
	public Book addBook(@RequestBody Book book)
	{
		return bookService.addBook(book);
	}
	
	@DeleteMapping("/deletebook/isbn/{isbn}")
	public Book deleteBook(@PathVariable("isbn") String isbn)
	{
		return bookService.deleteBook(isbn);
	}
	
}



