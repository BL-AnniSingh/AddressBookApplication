package com.bridgelabz.controller;

import com.bridgelabz.dto.request.BookRequestDto;
import com.bridgelabz.dto.response.BookResponseDto;
import com.bridgelabz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controller and responsebody
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.addBook(bookRequestDto);
    }

    @GetMapping("/{bookId}")
    public BookResponseDto getBookById(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping
    public BookResponseDto updateBook(
            @RequestParam int bookId,
            @RequestBody BookRequestDto bookRequestDto) {
        return bookService.updateBookById(bookId, bookRequestDto);
    }

    @DeleteMapping
    public String deleteBook(@RequestParam int bookId) {
        bookService.deleteBookById(bookId);
        return "Book deleted successfully";
    }
}
