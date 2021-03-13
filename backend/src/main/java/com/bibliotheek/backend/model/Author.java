package com.bibliotheek.backend.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
public class Author extends BaseJpaEntity {
    @NotNull
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "AUTHOR_BOOK",
            joinColumns = @JoinColumn(name = "AUTHOR_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    @Setter(AccessLevel.NONE)
    private List<Book> books;

    public void addBook(Book book) {
        this.books.add(book);
    }

}
