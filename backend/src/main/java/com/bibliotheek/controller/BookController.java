package com.bibliotheek.controller;

import com.bibliotheek.api.dto.BookDto;
import com.bibliotheek.service.BookService;
import com.bibliotheek.transform.BookToBookJsonMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bibliotheek.api.documentation.OpenApiConfig.API_ROOT;

@Tag(name = "Books", description = "Apis related to books")
@RestController
@RequestMapping(API_ROOT + "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/")
    public ResponseEntity<List<BookDto>> getBooks(HttpServletRequest request) {
        List<BookDto> books = bookService.list()
                .stream()
                .map(BookToBookJsonMapper::mapToBookJson)
                .collect(Collectors.toList());

        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }

    @Operation(description = "Returns a single book based on book id.",
            parameters = {@Parameter(name = "id", description = "book id", in = ParameterIn.PATH)})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content(schema = @Schema(implementation = Long.class),
                    examples = {@ExampleObject("{}")}))})
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<BookDto>> getBookById(HttpServletRequest request, @RequestParam long id) {
        Optional<BookDto> existingBook = bookService.list()
                .stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .map(BookToBookJsonMapper::mapToBookJson);

        return new ResponseEntity<>(existingBook, HttpStatus.ACCEPTED);
    }

    @Operation(description = "Add a new book. Returns book id in response.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Book created",
                    content = @Content(schema = @Schema(implementation = Long.class),
                            examples = {@ExampleObject("18001")})),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = Long.class),
                            examples = {@ExampleObject("-1")})),
            @ApiResponse(responseCode = "409", description = "Book already exists",
                    content = @Content(schema = @Schema(implementation = Long.class),
                            examples = {@ExampleObject("-1")}))})
    @PostMapping(value = "/")
    public ResponseEntity<Long> createBook(HttpServletRequest request, @RequestBody BookDto book) {
        // TODO: implement logic
        return new ResponseEntity<>(0L, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/")
    public ResponseEntity<List<BookDto>> deleteBooks() {
        bookService.deleteAll();
        List<BookDto> books = bookService.list()
                .stream()
                .map(BookToBookJsonMapper::mapToBookJson)
                .collect(Collectors.toList());
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }

}
