package com.lijie_su.library_management_system.lending_record;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="lending_record_table")
public class LendingRecord {
    @Id
    @SequenceGenerator(
        name="lending_record_seq",
        sequenceName = "lending_record_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "lending_record_seq"
    )
    private Long id;
    private Long borrower_id;
    private LocalDate borrower_date;
    private LocalDate due_date; 
    private List<Long> borrow_books_id;
    private boolean is_returned;
    private boolean is_overdue;

    public LendingRecord(){
    }
    public LendingRecord(Long borrower_id, LocalDate borrower_date, List<Long> borrow_books_id) {
        this.borrower_id = borrower_id;
        this.borrower_date = borrower_date;
        this.borrow_books_id = borrow_books_id;
        this.is_returned=false;
    }
    public Long getId() {
        return id;
    }

    public Long getBorrower_id() {
        return borrower_id;
    }
    public void setBorrower_id(Long borrower_id) {
        this.borrower_id = borrower_id;
    }
    public LocalDate getBorrower_date() {
        return borrower_date;
    }
    public void setBorrower_date(LocalDate borrower_date) {
        this.borrower_date = borrower_date;
    }
    public LocalDate getDue_date() {
        return borrower_date.plusDays(90);
    }
    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }
    public List<Long> getBorrow_books_id() {
        return borrow_books_id;
    }
    public void setBorrow_books_id(List<Long> borrow_books_id) {
        this.borrow_books_id = borrow_books_id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isIs_returned() {
        return is_returned;
    }
    public void setIs_returned(boolean is_returned) {
        this.is_returned = is_returned;
    }
}
