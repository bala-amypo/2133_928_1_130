package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warranty_claim_records")
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimantName;
    private String claimantEmail;
    private String claimReason;
    private String status;
    private LocalDateTime submittedAt;
    private LocalDateTime createdAt;

    public WarrantyClaimRecord() {}

    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
    private final WarrantyClaimRecord w = new WarrantyClaimRecord();

    public Builder id(Long id) { w.setId(id); return this; }
    public Builder serialNumber(String v) { w.setSerialNumber(v); return this; }
    public Builder claimantName(String v) { w.setClaimantName(v); return this; }
    public Builder claimantEmail(String v) { w.setClaimantEmail(v); return this; }
    public Builder claimReason(String v) { w.setClaimReason(v); return this; }
    public Builder status(String v) { w.setStatus(v); return this; }

    public WarrantyClaimRecord build() { return w; }
}


    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public String getClaimantName() { return claimantName; }
    public void setClaimantName(String claimantName) { this.claimantName = claimantName; }

    public String getClaimantEmail() { return claimantEmail; }
    public void setClaimantEmail(String claimantEmail) { this.claimantEmail = claimantEmail; }

    public String getClaimReason() { return claimReason; }
    public void setClaimReason(String claimReason) { this.claimReason = claimReason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
