package com.inge.club.book.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inge.club.book.models.Book;
import com.inge.club.book.repositories.BookRepository;

@Service
public class BookService {
	@Autowired 
	private BookRepository bookRepo;
	
	public List<Book> all(){
		return bookRepo.findAll();
	}
	
	
	public Book findBookById(Long id) {
		Optional<Book> aBook = bookRepo.findById(id);
		if(aBook.isEmpty()) {
			return null;
		}
		return aBook.get();	
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	
	public void delete(Book book) {
		bookRepo.delete(book);
	}
	
	
}
