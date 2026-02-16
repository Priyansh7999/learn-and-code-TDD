package com.testing.test_and_code.service;

import com.testing.test_and_code.model.Book;
import com.testing.test_and_code.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


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
    void shouldThrowException_WhenTitleIsEmpty(){
        assertThrows(IllegalAccessError.class,()->{
            bookService.createBook("","xyz");
        });
    }
    @Test
    void shouldThrowException_WhenAuthorIsEmpty(){
        assertThrows(IllegalAccessError.class,()->{
            bookService.createBook("xyz","");
        });
    }
}
