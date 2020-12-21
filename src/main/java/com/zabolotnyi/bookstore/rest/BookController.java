package com.zabolotnyi.bookstore.rest;

import com.zabolotnyi.bookstore.model.Book;
import com.zabolotnyi.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    //@GetMapping - что лучше использовать
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> getBook() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Book> getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteBook(@PathVariable("id") Long id) {
        bookService.removeBook(id);
        return "Deleted";
    }

    //
//    @RequestMapping(value = "/book", method = RequestMethod.PUT)
//    public void updateBook(@RequestParam(value = "id") Long id) {
//    }
//
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public @ResponseBody
    String addBook(@RequestBody Book book) {
        // Не могу проверить
        bookService.addBook(book);
        return "Added";
    }
}