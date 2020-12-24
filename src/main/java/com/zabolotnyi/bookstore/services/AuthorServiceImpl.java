package com.zabolotnyi.bookstore.services;

import com.zabolotnyi.bookstore.dao.AuthorRepository;
import com.zabolotnyi.bookstore.model.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        Author authorToSave = null;
        Optional<Author> authorToBeUpdated = authorRepository.findById(author.getId());
        if (authorToBeUpdated.isPresent()) {
            authorToSave = authorToBeUpdated.get();
        } else log.error("Author not found ");
        authorToSave.setName(author.getName());
        authorToSave.setSurname(author.getSurname());
        return authorRepository.save(authorToSave);
    }

    @Override
    public String removeAuthor(Long id) {
        authorRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }
}
