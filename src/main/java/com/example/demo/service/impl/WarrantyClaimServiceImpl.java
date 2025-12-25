package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.*;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;
    private final StolenDeviceReportRepository stolenRepository;
    private final FraudAlertRecordRepository alertRepository;
    private final FraudRuleRepository ruleRepository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository claimRepository,
                                    DeviceOwnershipRecordRepository deviceRepository,
                                    StolenDeviceReportRepository stolenRepository,
                                    FraudAlertRecordRepository alertRepository,
                                    FraudRuleRepository ruleRepository) {
        this.claimRepository = claimRepository;
        this.deviceRepository = deviceRepository;
        this.stolenRepository = stolenRepository;
        this.alertRepository = alertRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        DeviceOwnershipRecord device = deviceRepository
                .findBySerialNumber(claim.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Offer not found"));

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
    public WarrantyClaimRecord updateClaimStatus(Long claimId, String status) {
        WarrantyClaimRecord claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));
        claim.setStatus(status);
        return claimRepository.save(claim);
    }

    @Override
    public Optional<WarrantyClaimRecord> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return claimRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimRepository.findAll();
    }
}
