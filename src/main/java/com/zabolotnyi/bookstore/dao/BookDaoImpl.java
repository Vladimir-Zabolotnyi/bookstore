package com.zabolotnyi.bookstore.dao;

import com.zabolotnyi.bookstore.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        log.debug("{} is persisted", book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        log.debug("{} is updated", book);
    }

    @Override
    public boolean removeBook(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        if (book == null) {
            log.error("Book with id ={} is not existed", id);
            return false;
        }
        session.delete(book);
        log.debug("{} is deleted", book);
        return true;
    }

    @Override
    public Book getBookById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        log.debug("{} is loaded", book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> book = session.createQuery("FROM Book", Book.class).list();
        log.debug("{} list is loaded", book);
        return book;
    }
}
