package com.lijie_su.library_management_system.user;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @SequenceGenerator(
        name="user_seq",
        sequenceName = "user_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "user_seq"
    )
    private Long id;
    private String user_name;
    private String user_email;
    private String user_type;
    private LocalDate created_date;
    private List<Long> borrow_records_id;
    
    public User(String user_name, String user_email, String user_type, LocalDate created_date) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_type = user_type;
        this.created_date = created_date;
    }
    public User(String user_name, String user_email, String user_type) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_type = user_type;
        this.created_date=LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public List<Long> getBorrow_records_id() {
        return borrow_records_id;
    }

    public void setBorrow_records_id(List<Long> borrow_records_id) {
        this.borrow_records_id = borrow_records_id;
    }

}
