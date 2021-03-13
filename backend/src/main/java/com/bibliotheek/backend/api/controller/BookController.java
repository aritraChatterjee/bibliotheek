package com.bibliotheek.backend.api.controller;

import com.bibliotheek.backend.model.Book;
import com.bibliotheek.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * The version v1 of the controller make use of the service pattern
 */
@RestController
@RequestMapping("/v1")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book")
    public ResponseEntity<List<Book>> getBooks(HttpServletRequest request) {

        return new ResponseEntity<>(bookService.list(), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/book/delete")
    public ResponseEntity<List<Book>> deleteBooks() {
        bookService.deleteAll();
        return new ResponseEntity<>(bookService.list(), HttpStatus.ACCEPTED);
    }
}
