package com.lijie_su.library_management_system.lending_record;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LendingRecordService {
    private final LendingRecordRepository lendingRecordRepository;
    public LendingRecordService(LendingRecordRepository lendingRecordRepository){
        this.lendingRecordRepository=lendingRecordRepository;
    }
    public List<LendingRecord> getAllRecords() {
        return lendingRecordRepository.findAll();
    }
}
