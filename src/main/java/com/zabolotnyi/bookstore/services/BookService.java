package com.zabolotnyi.bookstore.services;

import com.zabolotnyi.bookstore.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    boolean removeBook(Long id);

    Book getBookById(Long id);

    List<Book> getAllBooks();
}
