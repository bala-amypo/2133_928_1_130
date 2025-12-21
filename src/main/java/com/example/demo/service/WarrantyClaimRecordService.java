package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.entity.WarrantyClaimRecordEntity;
import java.time.LocalDateTime;

@Service
public class WarrantyClaimRecordService {

    private final WarrantyClaimRecordRepository repo;

    public WarrantyClaimRecordService(WarrantyClaimRecordRepository repo) {
        this.repo = repo;
    }

    public WarrantyClaimRecordEntity submit(WarrantyClaimRecordEntity claim) {
        claim.setStatus(WarrantyClaimRecordEntity.Status.PENDING);
        claim.setCreatedAt(LocalDateTime.now());
        return repo.save(claim);
    }
}
