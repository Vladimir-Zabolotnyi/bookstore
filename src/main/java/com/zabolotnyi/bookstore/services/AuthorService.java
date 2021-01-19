package com.zabolotnyi.bookstore.services;

import com.zabolotnyi.bookstore.model.Author;
import com.zabolotnyi.bookstore.model.Book;

import java.util.List;

public interface AuthorService {
    Author addAuthor(Author author);

    Author updateAuthor(Author author);

    String removeAuthor(Long id);

    Author getAuthorById(Long id);

    List<Author> getAllAuthors();

}
