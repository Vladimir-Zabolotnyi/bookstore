package com.zabolotnyi.bookstore.rest;

import com.zabolotnyi.bookstore.model.Author;
import com.zabolotnyi.bookstore.services.AuthorService;
import com.zabolotnyi.bookstore.services.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public @ResponseBody List<Author> getAuthor() {
        return authorService.getAllAuthors();
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public @ResponseBody Author getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteAuthor(@PathVariable("id") Long id) {
        authorService.removeAuthor(id);
        return "Deleted";
    }

    @RequestMapping(value = "/author", method = RequestMethod.PUT)
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }


    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public @ResponseBody Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }


}
