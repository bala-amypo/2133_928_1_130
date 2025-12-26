package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class WarrantyClaimRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String claimReason;
    private String status;
    private LocalDate claimDate;

    // ✅ Required by tests
    public WarrantyClaimRecord() {
        this.status = "PENDING";
    }

    // =========================
    // ✅ BUILDER (MANDATORY)
    // =========================
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final WarrantyClaimRecord r = new WarrantyClaimRecord();

        public Builder id(Long id) {
            r.id = id;
            return this;
        }

        public Builder serialNumber(String serial) {
            r.serialNumber = serial;
            return this;
        }

        public Builder claimReason(String reason) {
            r.claimReason = reason;
            return this;
        }

        public Builder status(String status) {
            r.status = status;
            return this;
        }

        public Builder claimDate(LocalDate date) {
            r.claimDate = date;
            return this;
        }

        public WarrantyClaimRecord build() {
            return r;
        }
    }

    // =========================
    // GETTERS / SETTERS
    // =========================
    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public String getClaimReason() { return claimReason; }
    public String getStatus() { return status; }
    public LocalDate getClaimDate() { return claimDate; }

    public void setId(Long id) { this.id = id; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setClaimReason(String claimReason) { this.claimReason = claimReason; }
    public void setStatus(String status) { this.status = status; }
    public void setClaimDate(LocalDate claimDate) { this.claimDate = claimDate; }
}
