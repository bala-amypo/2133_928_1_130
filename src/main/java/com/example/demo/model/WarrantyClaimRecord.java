package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String serialNumber;

    @Column(nullable = false)
    private String claimantName;

    private String claimantEmail;

    @Column(nullable = false)
    private String claimReason;

    @Column(nullable = false)
    private String status = "PENDING";

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public WarrantyClaimRecord() {
    }

    public WarrantyClaimRecord(String serialNumber, String claimantName,
                               String claimantEmail, String claimReason) {
        this.serialNumber = serialNumber;
        this.claimantName = claimantName;
        this.claimantEmail = claimantEmail;
        this.claimReason = claimReason;
    }

    @PrePersist
    public void onCreate() {
        this.submittedAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "PENDING";
        }
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public String getClaimantEmail() {
        return claimantEmail;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
