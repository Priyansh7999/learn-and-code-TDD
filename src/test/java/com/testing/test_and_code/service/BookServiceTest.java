package com.testing.test_and_code.service;

import com.testing.test_and_code.model.Book;
import com.testing.test_and_code.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void ShouldReturnBook_WhenBookIsAddedSuccessfully() {
        //Given
        String title="Lost";
        String author="xyz";
        Book book=new Book(title,author);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        //When
        Book addedBook = bookService.createBook(title,author);

        // Then
        assertEquals(book,addedBook);
        assertEquals(title,addedBook.getTitle());
        assertEquals(author,addedBook.getAuthor());
    }

    @Test
    void ShouldReturnListOfBooks_WhenGetMethodIsCalled() {
        //Given
        Book book1=new Book("book1","xyz");
        Book book2=new Book("book2","abc");
        when(bookRepository.findAll()).thenReturn(List.of(book1,book2));

        //When
        List<Book> listOfBooks = bookService.getAllBooks();

        //Then
        assertEquals(2,listOfBooks.size());
        assertEquals(book1,listOfBooks.get(0));
        assertEquals(book2,listOfBooks.get(1));
    }
}
