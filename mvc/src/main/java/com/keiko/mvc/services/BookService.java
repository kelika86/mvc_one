package com.keiko.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.keiko.mvc.models.Book;
import com.keiko.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository= bookRepository;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id); //find by ID and it returns an Optional saying it may return or not
        if(optionalBook.isPresent()) { //if present
            return optionalBook.get(); //return
        } else {
            return null; //else return null
        }
    }
    public Book updateBook(Book book) {
    	return bookRepository.save(book);
    }
    //updates book--to update book you have to use setter methods from domain model and then call the save method
    public Book updateBook(Long id, String title, String desc, String lang, Integer numberOfPages) {
    	Book updateBook=bookRepository.findById(id).get();
    	updateBook.setTitle(title);
    	updateBook.setDescription(desc);
    	updateBook.setLanguage(lang);
    	updateBook.setNumberOfPages(numberOfPages);
    	return bookRepository.save(updateBook);
    }
    //deletes book
    public void deleteBook(long id) {
    	bookRepository.deleteById(id);
    }
}
