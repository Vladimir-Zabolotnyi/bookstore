package com.zabolotnyi.bookstore.services;


import com.zabolotnyi.bookstore.dao.BookDao;
import com.zabolotnyi.bookstore.dao.BookRepository;
import com.zabolotnyi.bookstore.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public void addBook(Book book) {
//        bookDao.addBook(book);
        bookRepository.save(book);
    }

    @Override

    public void updateBook(Book book) {
        Book bookToSave = null;
        Optional<Book> bookToBeUpdated = bookRepository.findById(book.getId());
        if (bookToBeUpdated.isPresent()) {
            bookToSave = bookToBeUpdated.get();
        }
        else log.error("Book not found ");
        bookToSave.setTitle(book.getTitle());
        bookToSave.setIssueYear(book.getIssueYear());
        bookToSave.setPrice(book.getPrice());
        bookToSave.setId(book.getId());
        bookToSave.setAuthor(book.getAuthor());
        bookRepository.save(bookToSave);

    }

    @Override

    public boolean removeBook(Long id) {
//        return bookDao.removeBook(id);
        bookRepository.deleteById(id);
        return true;
    }

    @Override

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();

//        return bookDao.getBookById(id);
    }

    @Override

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
}
