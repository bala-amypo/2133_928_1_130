package com.example.demo.model;

import java.time.LocalDateTime;

public class WarrantyClaimRecord {

    private Long id;
    private String serialNumber;
    private String claimantName;
    private String claimantEmail;
    private String claimReason;
    private String status;
    private LocalDateTime submittedAt;

    public WarrantyClaimRecord() {
        this.status = "PENDING"; // REQUIRED by test25
    }

    /* ================= GETTERS & SETTERS ================= */

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    /* ================= BUILDER ================= */

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final WarrantyClaimRecord r = new WarrantyClaimRecord();

        public Builder serialNumber(String v) { r.setSerialNumber(v); return this; }
        public Builder claimantName(String v) { r.setClaimantName(v); return this; }
        public Builder claimantEmail(String v) { r.setClaimantEmail(v); return this; }
        public Builder claimReason(String v) { r.setClaimReason(v); return this; }
        public Builder status(String v) { r.setStatus(v); return this; }
        public Builder submittedAt(LocalDateTime v) { r.setSubmittedAt(v); return this; }

        public WarrantyClaimRecord build() { return r; }
    }
}
