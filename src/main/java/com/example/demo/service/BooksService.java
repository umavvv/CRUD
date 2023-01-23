package com.example.demo.service;


import com.example.demo.Model.Book;
import com.example.demo.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) { //автоматическое связывание Autowired
        this.booksRepository = booksRepository;
    }

    public Book findById(Long id) {

        return booksRepository.getOne(id);
    }

    public List<Book> findAll() {

        return booksRepository.findAll();
    }

    public Book saveBooks(Book book) {

        return booksRepository.save(book);
    }

    public void deleteById(Long id) {
        booksRepository.deleteById(id);
    }
}