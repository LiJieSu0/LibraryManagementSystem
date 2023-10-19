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
    public List<LendingRecord> getRecordByUserId(Long user_id) {
        var recordList=lendingRecordRepository.findRecordByUserId(user_id);
        if(recordList.size()==0){
            throw new IllegalStateException("No record exist.");
        }
        return recordList;
    }
}
