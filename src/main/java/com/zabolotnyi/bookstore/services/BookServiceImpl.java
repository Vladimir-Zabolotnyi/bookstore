package com.zabolotnyi.bookstore.services;


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


    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book addBook(Book book) {
          return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Book bookToSave = null;
        Optional<Book> bookToBeUpdated = bookRepository.findById(book.getId());
        if (bookToBeUpdated.isPresent()) {
            bookToSave = bookToBeUpdated.get();
        }
        else log.error("Book not found ");
        bookToSave.setTitle(book.getTitle());
        bookToSave.setIssueYear(book.getIssueYear());
        bookToSave.setPrice(book.getPrice());
        bookToSave.setAuthor(book.getAuthor());
        return bookRepository.save(bookToSave);
    }

    @Override
    public String removeBook(Long id) {
        bookRepository.deleteById(id);
       return "Deleted";
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Iterable<Book> getBooksByTitle(String search) {
        return  bookRepository.findBookByTitleLike("%" + search + "%");
    }

    @Override
    public Book getBookByAuthor(String author) {
        return bookRepository.findBookByAuthor("%" + author + "%");
    }
}
