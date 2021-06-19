package com.bibliotheek.transform;

import com.bibliotheek.api.dto.BookDto;
import com.bibliotheek.model.Book;

public class BookToBookDtoMapper {
    private BookToBookDtoMapper() {
        // private constructor
    }

    public static BookDto mapToBookJson(Book book) {
        //TODO : implement logic
        return new BookDto();
    }
}
