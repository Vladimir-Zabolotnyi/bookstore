package com.zabolotnyi.bookstore.dao;

import com.zabolotnyi.bookstore.model.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long> {
}
