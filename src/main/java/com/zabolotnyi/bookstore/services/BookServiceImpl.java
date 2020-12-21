package com.zabolotnyi.bookstore.services;


import com.zabolotnyi.bookstore.dao.BookDao;
import com.zabolotnyi.bookstore.dao.BookRepository;
import com.zabolotnyi.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        //какой метод использовать?
//    bookRepository.
//        bookDao.updateBook(book);
    }

    @Override

    public boolean removeBook(Long id) {
//        return bookDao.removeBook(id);
        bookRepository.deleteById(id);
        return true;
    }

    @Override

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);

//        return bookDao.getBookById(id);
    }

    @Override

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
}