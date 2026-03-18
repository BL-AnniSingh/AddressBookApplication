package com.bridgelabz.service;

import com.bridgelabz.dto.request.BookRequestDto;
import com.bridgelabz.dto.response.BookResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookResponseDto addBook(BookRequestDto bookRequestDto);

    BookResponseDto getBookById(int bookId);

    List<BookResponseDto> getAllBooks();

    BookResponseDto updateBookById(int bookId, BookRequestDto bookRequestDto);

    void deleteBookById(int bookId);
}
