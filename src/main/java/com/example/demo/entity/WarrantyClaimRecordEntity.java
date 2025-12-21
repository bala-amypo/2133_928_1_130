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

    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public String getClaimReason() { return claimReason; }
    public String getStatus() { return status; }

    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setClaimReason(String claimReason) { this.claimReason = claimReason; }
    public void setStatus(String status) { this.status = status; }
}
