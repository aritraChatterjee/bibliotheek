package com.bibliotheek.service;

import com.bibliotheek.model.Book;
import com.bibliotheek.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAll();
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }

}
