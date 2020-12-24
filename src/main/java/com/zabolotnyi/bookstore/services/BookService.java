package com.zabolotnyi.bookstore.services;

import com.zabolotnyi.bookstore.model.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    Book updateBook(Book book);

    String removeBook(Long id);

    Book getBookById(Long id);

    List<Book> getAllBooks();

    Iterable<Book> getBooksByTitle(String search);

    Book getBookByAuthor(String author);
}
