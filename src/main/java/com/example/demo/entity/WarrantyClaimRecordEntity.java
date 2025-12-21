package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimantName;
    private String claimantEmail;
    private String claimReason;

    private String status = "PENDING";
    private LocalDateTime submittedAt;
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate() {
        submittedAt = LocalDateTime.now();
        createdAt = LocalDateTime.now();
    }

    public WarrantyClaimRecordEntity() {}

    // getters & setters
}
