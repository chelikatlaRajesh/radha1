package com.training.services.interfaces;

import java.util.List;

import com.training.entities.Book;



public interface BookServiceInterface {
	
	public Book getBook(String isbn);
	public Book addBook(Book book);
	public Book deleteBook(String isbn);
	public List<Book> getAllBooks();


}
