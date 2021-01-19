package com.zabolotnyi.bookstore.dao;

import com.zabolotnyi.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findBookByTitleLike(String search);
    Book findBookByAuthor(String Author);
}
