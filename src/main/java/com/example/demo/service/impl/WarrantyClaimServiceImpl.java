package com.example.demo.service.impl;

import com.example.demo.entity.DeviceOwnershipRecordEntity;
import com.example.demo.entity.WarrantyClaimRecordEntity;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyClaimRecordService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimRecordService {

    private final WarrantyClaimRecordRepository claimRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;
    private final StolenDeviceReportRepository stolenRepository;
    private final FraudAlertRecordRepository alertRepository;
    private final FraudRuleRepository fraudRuleRepository;

    // ⚠️ EXACT constructor order (test critical)
    public WarrantyClaimServiceImpl(
            WarrantyClaimRecordRepository claimRepository,
            DeviceOwnershipRecordRepository deviceRepository,
            StolenDeviceReportRepository stolenRepository,
            FraudAlertRecordRepository alertRepository,
            FraudRuleRepository fraudRuleRepository
    ) {
        this.claimRepository = claimRepository;
        this.deviceRepository = deviceRepository;
        this.stolenRepository = stolenRepository;
        this.alertRepository = alertRepository;
        this.fraudRuleRepository = fraudRuleRepository;
    }

    @Override
    public WarrantyClaimRecordEntity submitClaim(WarrantyClaimRecordEntity claim) {

        DeviceOwnershipRecordEntity device = deviceRepository
                .findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Device not found"));

        boolean flagged = false;

        if (stolenRepository.existsBySerialNumber(claim.getSerialNumber())) {
            flagged = true;
        }

        if (device.getWarrantyExpiration().isBefore(LocalDate.now())) {
            flagged = true;
        }

        if (claimRepository.existsBySerialNumberAndClaimReason(
                claim.getSerialNumber(), claim.getClaimReason())) {
            flagged = true;
        }

        if (flagged) {
            claim.setStatus("FLAGGED");
        }

        return claimRepository.save(claim);
    }

    @Override
    public WarrantyClaimRecordEntity updateClaimStatus(Long claimId, String status) {

        WarrantyClaimRecordEntity claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));

        claim.setStatus(status);
        return claimRepository.save(claim);
    }

    @Override
    public WarrantyClaimRecordEntity getClaimById(Long id) {

        return claimRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));
    }

    @Override
    public List<WarrantyClaimRecordEntity> getClaimsBySerial(String serialNumber) {
        return claimRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecordEntity> getAllClaims() {
        return claimRepository.findAll();
    }
}
