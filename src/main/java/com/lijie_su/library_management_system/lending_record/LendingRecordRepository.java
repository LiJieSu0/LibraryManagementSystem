package com.lijie_su.library_management_system.lending_record;

import com.lijie_su.library_management_system.book.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingRecordRepository extends JpaRepository<LendingRecord,Long> {
    @Query("SELECT r FROM LendingRecord r WHERE r.borrower_id=?1")
    public List<LendingRecord> findRecordByUserId(Long user_id);
}
