package com.example.demo.service.impl;

import com.example.demo.entity.FraudAlertRecordEntity;
import com.example.demo.repository.FraudAlertRecordRepository;
import com.example.demo.service.FraudAlertRecordService;

import java.util.List;
import java.util.NoSuchElementException;

public class FraudAlertServiceImpl implements FraudAlertRecordService {

    private final FraudAlertRecordRepository repository;

    public FraudAlertServiceImpl(FraudAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudAlertRecordEntity createAlert(FraudAlertRecordEntity alert) {
        return repository.save(alert);
    }

    @Override
    public FraudAlertRecordEntity resolveAlert(Long id) {

        FraudAlertRecordEntity alert = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Match not found"));

        alert.setResolved(true);
        return repository.save(alert);
    }

    @Override
    public List<FraudAlertRecordEntity> getAlertsBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<FraudAlertRecordEntity> getAlertsByClaim(Long claimId) {
        return repository.findByClaimId(claimId);
    }

    @Override
    public List<FraudAlertRecordEntity> getAllAlerts() {
        return repository.findAll();
    }
}
