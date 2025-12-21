package com.example.demo.service;

import com.example.demo.entity.WarrantyClaimRecordEntity;
import java.util.List;

public interface WarrantyClaimRecordService {

    WarrantyClaimRecordEntity submitClaim(WarrantyClaimRecordEntity claim);

    WarrantyClaimRecordEntity updateClaimStatus(Long claimId, String status);

    WarrantyClaimRecordEntity getClaimById(Long id);

    List<WarrantyClaimRecordEntity> getClaimsBySerial(String serialNumber);

    List<WarrantyClaimRecordEntity> getAllClaims();
}
