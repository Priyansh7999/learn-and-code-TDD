package com.testing.test_and_code.service;

import com.testing.test_and_code.model.Book;
import com.testing.test_and_code.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Book createBook(String title, String author) {
        return bookRepository.save(new Book(title,author));
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}