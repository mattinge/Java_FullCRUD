package com.inge.club.book.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inge.club.book.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
}
