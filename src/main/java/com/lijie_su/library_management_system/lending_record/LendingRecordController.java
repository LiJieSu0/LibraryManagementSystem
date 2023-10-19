package com.lijie_su.library_management_system.lending_record;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/record")
public class LendingRecordController {
    private final LendingRecordService lendingRecordService;
    public LendingRecordController(LendingRecordService lendingRecordService){
        this.lendingRecordService=lendingRecordService;
    }

    @GetMapping
    public List<LendingRecord> getAllRecords(){
        return lendingRecordService.getAllRecords();
    }
    
}
