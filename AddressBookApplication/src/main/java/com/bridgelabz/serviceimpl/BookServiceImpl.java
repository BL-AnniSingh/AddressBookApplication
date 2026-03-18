package com.bridgelabz.serviceimpl;

import com.bridgelabz.dto.request.BookRequestDto;
import com.bridgelabz.dto.response.BookResponseDto;
import com.bridgelabz.entity.Book;
import com.bridgelabz.repository.BookRepository;
import com.bridgelabz.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {

        Book book = modelMapper.map(bookRequestDto, Book.class);
        Book savedBook = bookRepository.save(book);

        return modelMapper.map(savedBook, BookResponseDto.class);
    }

    @Override
    public BookResponseDto getBookById(int bookId) {

        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return modelMapper.map(book, BookResponseDto.class);
        } else {
            throw new EntityNotFoundException("Book not found with id: " + bookId);
        }
    }

    @Override
    public List<BookResponseDto> getAllBooks() {

        List<Book> bookList = bookRepository.findAll();
        List<BookResponseDto> responseList = new ArrayList<>();

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            BookResponseDto dto = modelMapper.map(book, BookResponseDto.class);
            responseList.add(dto);
        }

        return responseList;
    }

    @Override
    public BookResponseDto updateBookById(int bookId, BookRequestDto bookRequestDto) {

        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();

            modelMapper.map(bookRequestDto, book);
            Book updatedBook = bookRepository.save(book);

            return modelMapper.map(updatedBook, BookResponseDto.class);
        } else {
            throw new EntityNotFoundException("Book not found with id: " + bookId);
        }
    }

    @Override
    public void deleteBookById(int bookId) {

        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            bookRepository.delete(optionalBook.get());
        } else {
            throw new EntityNotFoundException("Book not found with id: " + bookId);
        }
    }
}
