package com.example.demo.controller;

import com.example.demo.Model.Book;
import com.example.demo.service.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class BooksController {
    private final BooksService booksService;

    public BooksController(BooksService booksService) { //Autowired
        this.booksService = booksService;
    }

    @GetMapping("/book")
    public String findAll(Model model) {
        List<Book> books = booksService.findAll();
        model.addAttribute("books", books);
        return "books-list";
    }

    @GetMapping("/book-create")
    public String createBookForm(Book book) { //создаются книги
        return "book-create";
    }


    @PostMapping("/book-create")
    public String createBook(Book book) {
        booksService.saveBooks(book); // книги сохраняются в БД
        return "redirect:/book";
    }

    @GetMapping("book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        booksService.deleteById(id);
        return "redirect:/book";
    }

    @GetMapping("/book-update/{id}")
    public String updateBookForm(@PathVariable("id") Long id, Model model) {
        Book book = booksService.findById(id);
        model.addAttribute("book", book);
        return "book-update";
    }

    @PostMapping("/book-update")
    public String updateUser(Book book) {
        booksService.saveBooks(book);
        return "redirect:/book";

    }
}