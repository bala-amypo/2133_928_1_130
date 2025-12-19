package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.WarrantyClaimRecordEntity;

public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecordEntity, Long> {}
