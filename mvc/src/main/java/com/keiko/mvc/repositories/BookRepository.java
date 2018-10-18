package com.keiko.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keiko.mvc.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll(); //method to retrieve all books from db
	List<Book> findByDescriptionContaining(String search); //method to find a book by their descrip
	Long countByTitleContaining(String search);// method to count how many times it contains a certain title
	Long deleteByTitleStartingWith(String search);
}


