package com.bibliotheek.transform;

import com.bibliotheek.api.dto.BookDto;
import com.bibliotheek.model.Author;
import com.bibliotheek.model.Book;
import com.bibliotheek.model.Language;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class BookToBookDtoMapperTest {

    @Test
    void mapToBookDto() {
        Author author = Author.builder()
                .firstName("Rudyard")
                .lastName("Kipling")
                .build();

        Book testBook = Book.builder()
                .title("The Jungle Book")
                .language(Language.EN)
                .authors(Collections.singletonList(author))
                .build();

        testBook.setId(1L);

        BookDto mappedBookDto = BookToBookDtoMapper.mapToBookDto(testBook);

        assertThat(mappedBookDto.getId()).isEqualTo(1L);
        assertThat(mappedBookDto.getTitle()).isEqualTo("The Jungle Book");
        assertThat(mappedBookDto.getAuthors().size()).isEqualTo(1);
        assertThat(mappedBookDto.getAuthors().get(0).getFirstName()).isEqualTo("Rudyard");
        assertThat(mappedBookDto.getAuthors().get(0).getLastName()).isEqualTo("Kipling");
    }
}