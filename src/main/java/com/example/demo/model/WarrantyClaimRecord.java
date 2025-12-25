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
    private String status = "PENDING";
    private LocalDateTime submittedAt;

    public WarrantyClaimRecord() {}

    /* ===== REQUIRED BY TESTS ===== */
    public void setId(long id) {
        this.id = id;
    }

    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public String getClaimReason() { return claimReason; }
    public String getStatus() { return status; }

    /* ===== BUILDER ===== */
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final WarrantyClaimRecord r = new WarrantyClaimRecord();

        public Builder id(Long id) {
            r.id = id;
            return this;
        }

        public Builder serialNumber(String s) {
            r.serialNumber = s;
            return this;
        }

        public Builder claimantName(String n) {
            r.claimantName = n;
            return this;
        }

        public Builder claimantEmail(String e) {
            r.claimantEmail = e;
            return this;
        }

        public Builder claimReason(String c) {
            r.claimReason = c;
            return this;
        }

        public Builder status(String s) {
            r.status = s;
            return this;
        }

        public Builder submittedAt(LocalDateTime t) {
            r.submittedAt = t;
            return this;
        }

        public WarrantyClaimRecord build() {
            return r;
        }
    }
}
