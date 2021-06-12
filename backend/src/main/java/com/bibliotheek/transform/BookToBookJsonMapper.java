package com.bibliotheek.transform;

import com.bibliotheek.api.dto.BookDto;
import com.bibliotheek.model.Book;

public class BookToBookJsonMapper {
    private BookToBookJsonMapper() {
        // private constructor
    }

    public static BookDto mapToBookJson(Book book) {
        //TODO : implement logic
        return new BookDto();
    }
}
