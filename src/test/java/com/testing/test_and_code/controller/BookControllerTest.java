package com.testing.test_and_code.controller;

import com.testing.test_and_code.model.Book;
import com.testing.test_and_code.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @MockitoBean
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void ShouldReturn201AndBook_WhenBookAddedSuccessfully() throws Exception {
        //Given
        Book book = new Book("lost","xyz");
        when(bookService.createBook("lost","xyz")).thenReturn(book);

        //When
        mockMvc.perform(MockMvcRequestBuilders.post("/books").contentType(MediaType.APPLICATION_JSON).content(
                        objectMapper.writeValueAsString(book))).andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("lost"))
                .andExpect(jsonPath("$.author").value("xyz"));
    }

    @Test
    public void ShouldReturn200AndListOfBooks_WhenGetAllBooksMethodIsCalled() throws Exception {
        // Given
        List<Book> listOfBooks = List.of(new Book("book1","xyz"),new Book("book2","xyz"));

        when(bookService.getAllBooks()).thenReturn(listOfBooks);

        //When
        mockMvc.perform(MockMvcRequestBuilders.get("/books").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title").value("book1"))
                .andExpect(jsonPath("$[0].author").value("xyz"))
                .andExpect(jsonPath("$[1].title").value("book2"))
                .andExpect(jsonPath("$[1].author").value("xyz"));

    }
}
