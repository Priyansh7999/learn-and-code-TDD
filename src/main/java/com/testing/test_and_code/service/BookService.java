package com.testing.test_and_code.service;

import com.testing.test_and_code.model.Book;
import com.testing.test_and_code.repository.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book createBook(String title, String author) {
        return bookRepository.save(new Book(title,author));
    }
}