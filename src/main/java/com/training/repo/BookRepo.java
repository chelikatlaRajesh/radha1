package com.training.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book,String>{

	List<Book> findByTitle(String title);
	List<Book> findByStockGreaterThan(long stock);
	List<Book> findByTitleLike(String title); // %C%
	
	//all books that that are priced above 200.0
	
	@Query("from Book b where b.price > :price")
	List<Book> getAllBooksPriceGt(@Param("price") double price);
	
	// update stock of all books which have less than 120 by 50
	@Query("update Book b set b.stock=b.stock+:newstock where b.stock < :oldstock")
	@Modifying
	@Transactional
	int updateBookStock(@Param("oldstock") long oldStock,@Param("newstock")long newStock);
	
}







