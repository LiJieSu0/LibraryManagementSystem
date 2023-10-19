package com.lijie_su.library_management_system.book;

import java.time.LocalDate;
import java.util.List;

import com.lijie_su.library_management_system.author.Author;
import com.lijie_su.library_management_system.lending_record.LendingRecord;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="book_table")
public class Book {
    @Id
    @SequenceGenerator(
        name="book_seq",
        sequenceName = "book_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_seq"
    )
    private Long id;
    private String book_name;
    private List<String> book_types;
    private int curr_amount;
    private LocalDate publish_date;
    private List<Long> authors_id;
    private List<Long> borrower_id;
    
    public Book(String book_name, List<String> book_types, int curr_amount, LocalDate publish_date,List<Long> authors_id) {
        this.book_name = book_name;
        this.book_types = book_types;
        this.curr_amount = curr_amount;
        this.publish_date = publish_date;
        this.authors_id = authors_id;
    }

    public Book(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public List<String> getBook_types() {
        return book_types;
    }

    public void setBook_types(List<String> book_types) {
        this.book_types = book_types;
    }

    public int getCurr_amount() {
        return curr_amount;
    }

    public void setCurr_amount(int curr_amount) {
        this.curr_amount = curr_amount;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    public List<Long> getAuthors() {
        return authors_id;
    }

    public void setAuthors(List<Long> authors_id) {
        this.authors_id = authors_id;
    }

    public List<Long> getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(List<Long> authors_id) {
        this.authors_id = authors_id;
    }

    public List<Long> getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(List<Long> borrower_id) {
        this.borrower_id = borrower_id;
    }
    public void addBorrower_id(Long borrower_id){
        this.borrower_id.add(borrower_id);
    }
}
