package com.lijie_su.library_management_system.lending_record;

import com.lijie_su.library_management_system.book.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingRecordRepository extends JpaRepository<LendingRecord,Long> {
    
}
