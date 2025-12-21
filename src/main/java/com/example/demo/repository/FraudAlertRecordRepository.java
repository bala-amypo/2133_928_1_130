package com.example.demo.repository;

import com.example.demo.entity.FraudAlertRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudAlertRecordRepository
        extends JpaRepository<FraudAlertRecordEntity, Long> {

    List<FraudAlertRecordEntity> findByClaimId(Long claimId);

    List<FraudAlertRecordEntity> findBySerialNumber(String serialNumber);
}
