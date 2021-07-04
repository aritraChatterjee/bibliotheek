package com.bibliotheek.transform;

import com.bibliotheek.api.dto.AuthorDto;
import com.bibliotheek.api.dto.BookDto;
import com.bibliotheek.model.Author;
import com.bibliotheek.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookToBookDtoMapper {
    private BookToBookDtoMapper() {
        // private constructor
    }

    public static BookDto mapToBookDto(Book book) {
        var bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setLanguage(book.getLanguage());
        bookDto.setAuthors(mapToAuthorDtos(book.getAuthors()));
        return bookDto;
    }

    private static List<AuthorDto> mapToAuthorDtos(List<Author> authors) {
        return authors.stream()
                .map(BookToBookDtoMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    private static AuthorDto mapToAuthorDto(Author author) {
        var authorDto = new AuthorDto();
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        return authorDto;
    }
}
