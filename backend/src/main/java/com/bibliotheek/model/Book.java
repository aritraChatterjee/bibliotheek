package com.bibliotheek.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Book extends BaseJpaEntity {
    @NotNull
    private String title;

    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToMany(mappedBy = "books")
    @Setter(AccessLevel.NONE)
    private List<Author> authors;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(name = "BOOK_TAG",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    @Setter(AccessLevel.NONE)
    private List<Tag> tags;

    @ManyToOne
    private Shelf shelf;


    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addReview(Review review) {
        review.setBook(this);
        this.reviews.add(review);
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

}
