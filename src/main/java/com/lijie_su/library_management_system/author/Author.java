package com.lijie_su.library_management_system.author;

import java.util.List;

import com.lijie_su.library_management_system.book.Book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="author_table")
public class Author {
    @Id
    @SequenceGenerator(
        name="author_seq",
        sequenceName = "author_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "author_seq"
    )
    private Long id;
    private String name;
    private List<Long> published_books_id;

    public Author(){
    }
    public Author(String name) {
        this.name = name;
    }

    public Author(String name, List<Long> published_books_id) {
        this.name = name;
        this.published_books_id = published_books_id;
    }


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Long> getPublished_books_id() {
        return published_books_id;
    }
    public void setPublished_books_id(List<Long> published_books_id) {
        this.published_books_id = published_books_id;
    }

}
