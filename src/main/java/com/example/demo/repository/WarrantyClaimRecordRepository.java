package com.example.demo.repository;

import com.example.demo.entity.WarrantyClaimRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecordEntity, Long> {

    boolean existsBySerialNumberAndClaimReason(String serialNumber, String claimReason);

    List<WarrantyClaimRecordEntity> findBySerialNumber(String serialNumber);
}
