package com.jac.alexandria.Alexandria.Library.controller;

import com.jac.alexandria.Alexandria.Library.entity.Book;
import com.jac.alexandria.Alexandria.Library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    public BookController(BookService theBookService) {
        bookService = theBookService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listBooks(Model theModel) {

        //get the book from db
        List<Book> theBook = bookService.findAll();

        // add to the spring model
        theModel.addAttribute("books", theBook);

        return "books/list-books";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "books/book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book theBook) {

        // save the book
        bookService.save(theBook);

        // use a redirect to prevent duplicate submissions
        return "redirect:/books/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {

        // get the book from the service
        Book theBook = bookService.findById(theId);

        // set book as a model attribute to pre-populate the form
        theModel.addAttribute("book", theBook);

        // send over to our form
        return "books/book-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {

        // delete the book
        bookService.deleteById(theId);

        // redirect to /books/list
        return "redirect:/books/list";
    }

}

