package com.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entities.Book;
import com.training.repo.BookRepo;
import com.training.services.interfaces.BookServiceInterface;

@Service
public class BookService implements BookServiceInterface {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public Book getBook(String isbn) {
		Optional<Book> bookOp = bookRepo.findById(isbn);
		if(bookOp.isPresent())
		return bookOp.get();
		return null;
	}

	@Override
	public Book addBook(Book book) {
		
		return bookRepo.save(book);
	}

	@Override
	public Book deleteBook(String isbn) {
		Optional<Book> bookOp = bookRepo.findById(isbn);
		if(bookOp.isPresent())
		{
			Book bookDeleted = bookOp.get();
			bookRepo.delete(bookDeleted);
			return bookDeleted;
		}
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepo.findAll();
	}

}
