package com.zabolotnyi.bookstore.rest;

import com.zabolotnyi.bookstore.model.Book;
import com.zabolotnyi.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public @ResponseBody List<Book> getBook() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteBook(@PathVariable("id") Long id) {
        bookService.removeBook(id);
        return "Deleted";
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    public  Book  updateBook(@RequestBody Book book) {
       return bookService.updateBook(book);
    }


    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public @ResponseBody Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(value = "/book/search", method = RequestMethod.GET)
    public @ResponseBody Iterable<Book> getBookByTitle(@RequestParam(value = "search") String search) {
        return bookService.getBooksByTitle(search);
    }
    @RequestMapping(value = "book/author",method = RequestMethod.GET)
    public @ResponseBody Book getBookByAuthor(@RequestParam(value = "author") String author){
    return bookService.getBookByAuthor(author);
    }
}
