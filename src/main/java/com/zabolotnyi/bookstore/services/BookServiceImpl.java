package com.zabolotnyi.bookstore.services;


import com.zabolotnyi.bookstore.dao.BookDao;
import com.zabolotnyi.bookstore.dao.BookRepository;
import com.zabolotnyi.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Book book1 = bookRepository.findById(book.getId()).get();
        book1.setTitle(book.getTitle());
        book1.setIssueYear(book.getIssueYear());
        book1.setPrice(book.getPrice());
        book1.setId(book.getId());
        book1.setAuthor(book.getAuthor());
        bookRepository.save(book1);

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
